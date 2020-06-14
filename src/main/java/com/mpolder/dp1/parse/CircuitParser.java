package com.mpolder.dp1.parse;

import com.mpolder.dp1.gate.IGate;
import com.mpolder.dp1.gate.IGateFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CircuitParser implements ICircuitParser {
    private IReader reader;
    private IGateFactory gateFactory;

    public CircuitParser(IReader reader, IGateFactory gateFactory) {
        this.reader = reader;
        this.gateFactory = gateFactory;
    }

    public List<IGate> parse() throws IOException {
        HashMap<String, IGate> gates = new HashMap<>();

        for (String line : reader.read()) {
            String[] parts = line.split(":");
            if (parts.length == 2) {
                String name = parts[0];
                String part = parts[1];
                if (!gates.containsKey(name)) {
                    IGate newGate = gateFactory.create(part, name);
                    gates.put(name, newGate);
                } else {
                    IGate original = gates.get(name);
                    if (original != null) {
                        String[] toLink = part.split(",");
                        for (String link : toLink) {
                            gates.get(link).attachInput(original);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(gates.values());
    }
}
