package com.mpolder.dp1.gate;

import com.mpolder.dp1.circuit.Circuit;

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
    protected boolean requiresOutput() {
        return false;
    }

    @Override
    public IGate cloneGate(String id) {
        return new ProbeGate(id);
    }
}
