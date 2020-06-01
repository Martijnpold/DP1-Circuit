package com.mpolder.gate;

import com.mpolder.exception.CircuitLoopException;

public class NotGate extends ISingleInputGate {
    public NotGate(String id) {
        super(id);
    }

    @Override
    public boolean calculateOutput() throws CircuitLoopException {
        try {
            return !input.getOutput();
        } catch (StackOverflowError e) {
            throw new CircuitLoopException();
        }
    }

    @Override
    public IGate cloneGate(String id) {
        return new NotGate(id);
    }
}
