package com.mpolder.dp1.gate;

public class NorGate extends IMultiInputGate {
    public NorGate(String id) {
        super(id);
    }

    @Override
    public boolean calculateOutput() {
        return combinedInputs() == 0;
    }

    @Override
    public IGate cloneGate(String id) {
        return new NorGate(id);
    }
}
