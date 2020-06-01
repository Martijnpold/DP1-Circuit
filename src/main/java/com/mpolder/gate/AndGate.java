package com.mpolder.gate;

public class AndGate extends IMultiInputGate {
    public AndGate(String id) {
        super(id);
    }

    @Override
    public boolean calculateOutput() {
        return combinedInputs() == inputs.size();
    }

    @Override
    public IGate cloneGate(String id) {
        return new AndGate(id);
    }
}
