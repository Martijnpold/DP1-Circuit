package com.mpolder.gate;

public class NotGate extends ISingleInputGate {
    public NotGate(String id) {
        super(id);
    }

    @Override
    public boolean calculateOutput() {
        return !input.getOutput();
    }

    @Override
    public IGate cloneGate(String id) {
        return new NotGate(id);
    }
}
