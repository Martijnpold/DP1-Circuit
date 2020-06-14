package com.mpolder.dp1.parse;

import com.mpolder.dp1.gate.IGate;
import com.mpolder.dp1.gate.IGateFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CircuitParser implements ICircuitParser {
    public List<IGate> parse(IGateFactory gateFactory, List<String> lines) {
        HashMap<String, IGate> gates = new HashMap<>();

        for (String line : lines) {
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
