package com.mpolder.dp1.gate;

public class NandGate extends IMultiInputGate {
    public NandGate(String id) {
        super(id);
    }

    @Override
    public boolean calculateOutput() {
        return combinedInputs() <= 1;
    }

    @Override
    public IGate cloneGate(String id) {
        return new NandGate(id);
    }
}
