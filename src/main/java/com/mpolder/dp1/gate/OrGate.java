package com.mpolder.dp1.gate;

public class OrGate extends IMultiInputGate {
    public OrGate(String id) {
        super(id);
    }

    @Override
    public boolean calculateOutput() {
        return combinedInputs() > 0;
    }

    @Override
    public IGate cloneGate(String id) {
        return new OrGate(id);
    }
}
