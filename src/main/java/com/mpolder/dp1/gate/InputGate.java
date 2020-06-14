package com.mpolder.dp1.gate;

import com.mpolder.dp1.circuit.Circuit;
import com.mpolder.dp1.exception.CircuitFormatException;
import com.mpolder.dp1.exception.CircuitNodeAlreadyAttachedException;

public class InputGate extends IGate {
    private boolean output;

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
        throw new CircuitNodeAlreadyAttachedException("The node " + getId() + " has too many inputs");
    }

    @Override
    public void attachCircuit(Circuit circuit) {
        circuit.attachInput(this);
    }

    @Override
    public void toggle() {
        this.output = !this.output;
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
