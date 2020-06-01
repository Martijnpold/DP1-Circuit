package com.mpolder.gate;

import com.mpolder.exception.CircuitFormatException;
import com.mpolder.exception.CircuitNodeAlreadyAttachedException;

public class InputGate extends IGate {
    private final boolean output;

    InputGate(String id, boolean output) {
        super(id);
        this.output = output;
    }

    @Override
    public boolean calculateOutput() {
        return output;
    }

    @Override
    public void attachInput(IGate gate) throws CircuitFormatException {
        throw new CircuitNodeAlreadyAttachedException();
    }

    @Override
    public boolean requiresOutput() {
        return false;
    }

    @Override
    public boolean validateInput() {
        return true;
    }

    @Override
    public IGate cloneGate(String id) {
        return new InputGate(id, output);
    }
}
