package com.mpolder.gate;

public class XorGate extends IMultiInputGate {
    public XorGate(String id) {
        super(id);
    }

    @Override
    public boolean calculateOutput() {
        return combinedInputs() == 1;
    }

    @Override
    public IGate cloneGate(String id) {
        return new XorGate(id);
    }
}
