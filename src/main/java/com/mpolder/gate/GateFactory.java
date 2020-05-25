package com.mpolder.gate;

import com.mpolder.exception.CircuitNodeTypeNotFoundException;

import java.util.HashMap;

public class GateFactory implements IGateFactory {
    private HashMap<String, IGate> gates;

    public GateFactory() {
        gates = new HashMap<>();
        init();
    }

    private void init() {
        gates.put("INPUT_HIGH", new InputGate(true));
        gates.put("INPUT_LOW", new InputGate(false));
        gates.put("AND", new AndGate());
        gates.put("NAND", new NandGate());
        gates.put("NOR", new NorGate());
        gates.put("NOT", new NotGate());
        gates.put("OR", new OrGate());
        gates.put("PROBE", new ProbeGate());
        gates.put("XOR", new XorGate());
    }

    public IGate create(String gate) throws CircuitNodeTypeNotFoundException {
        try {
            if (gates.containsKey(gate)) {
                return (IGate) gates.get(gate).clone();
            }
        } catch (CloneNotSupportedException e) {
            //Ignore
        }
        throw new CircuitNodeTypeNotFoundException();
    }
}
