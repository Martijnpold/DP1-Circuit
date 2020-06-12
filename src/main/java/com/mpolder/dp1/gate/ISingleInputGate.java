package com.mpolder.dp1.gate;

import com.mpolder.dp1.exception.CircuitFormatException;
import com.mpolder.dp1.exception.CircuitNodeAlreadyAttachedException;

public abstract class ISingleInputGate extends IGate {
    protected IGate input;

    public ISingleInputGate(String id) {
        super(id);
    }

    @Override
    public void attachInput(IGate gate) throws CircuitFormatException {
        if (input != null) throw new CircuitNodeAlreadyAttachedException();
        gate.attachOutput(this);
        input = gate;
    }

    @Override
    public boolean validateInput() {
        return input != null;
    }
}
