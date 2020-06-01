package com.mpolder.gate;

import com.mpolder.circuit.Circuit;

public class ProbeGate extends ISingleInputGate {
    public ProbeGate(String id) {
        super(id);
    }

    @Override
    public boolean calculateOutput() {
        return input.getOutput();
    }

    @Override
    public void attachCircuit(Circuit circuit) {
        circuit.attachOutput(this);
    }

    @Override
    public boolean requiresOutput() {
        return false;
    }

    @Override
    public IGate cloneGate(String id) {
        return new ProbeGate(id);
    }
}
