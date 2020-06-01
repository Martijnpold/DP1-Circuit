package com.mpolder.parse;

import com.mpolder.exception.CircuitFormatException;
import com.mpolder.exception.CircuitNodeDetachedException;
import com.mpolder.gate.IGate;
import com.mpolder.gate.IGateFactory;

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

    public List<IGate> parse() throws IOException, CircuitFormatException {
        HashMap<String, IGate> gates = new HashMap<>();
        List<IGate> unconnected = new ArrayList<>();

        for (String line : reader.read()) {
            String[] parts = line.split(":");
            if (parts.length == 2) {
                String name = parts[0];
                String part = parts[1];
                if (!gates.containsKey(name)) {
                    IGate newGate = gateFactory.create(part, name);
                    gates.put(name, newGate);
                    if (newGate.requiresOutput())
                        unconnected.add(newGate);
                } else {
                    IGate original = gates.get(name);
                    if (original != null) {
                        String[] toLink = part.split(",");
                        for (String link : toLink) {
                            gates.get(link).attachInput(original);
                            unconnected.remove(original);
                        }
                    }
                }
            }
        }
        if (unconnected.size() > 0) throw new CircuitNodeDetachedException();
        for (IGate gate : gates.values()) {
            if (gate == null || !gate.validate()) {
                throw new CircuitNodeDetachedException();
            }
        }
        return new ArrayList<>(gates.values());
    }
}
