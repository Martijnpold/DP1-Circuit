package com.mpolder.gate;

import com.mpolder.circuit.Circuit;
import com.mpolder.exception.CircuitFormatException;

public class OrGate extends IGate {
    @Override
    public boolean getOutput() throws CircuitFormatException {
        return false;
    }

    @Override
    public void attachOutput(IGate gate) {

    }

    @Override
    public void attachCircuit(Circuit circuit) {

    }

    @Override
    public boolean validate() {
        return false;
    }
}
