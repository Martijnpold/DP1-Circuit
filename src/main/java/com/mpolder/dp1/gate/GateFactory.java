package com.mpolder.dp1.gate;

import com.mpolder.dp1.exception.CircuitNodeTypeNotFoundException;

import java.util.HashMap;

public class GateFactory implements IGateFactory {
    private final HashMap<String, IGate> gates;

    private static final String DEF_ID = "FACTORY_GATE";

    public GateFactory() {
        gates = new HashMap<>();
        init();
    }

    private void init() {
        gates.put("INPUT_HIGH", new InputGate(DEF_ID, true));
        gates.put("INPUT_LOW", new InputGate(DEF_ID, false));
        gates.put("AND", new AndGate(DEF_ID));
        gates.put("NAND", new NandGate(DEF_ID));
        gates.put("NOR", new NorGate(DEF_ID));
        gates.put("NOT", new NotGate(DEF_ID));
        gates.put("OR", new OrGate(DEF_ID));
        gates.put("PROBE", new ProbeGate(DEF_ID));
        gates.put("XOR", new XorGate(DEF_ID));
    }

    public IGate create(String gate, String id) throws CircuitNodeTypeNotFoundException {
        if (gates.containsKey(gate)) {
            return gates.get(gate).cloneGate(id);
        }
        throw new CircuitNodeTypeNotFoundException("Node type " + gate + " is not available");
    }
}
