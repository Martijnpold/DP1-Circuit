package com.mpolder.gate;

import com.mpolder.circuit.Circuit;
import com.mpolder.exception.CircuitFormatException;

public class InputGate extends IGate {
    InputGate(boolean output) {
        this.output = output;
    }

    @Override
    public boolean calculateOutput() throws CircuitFormatException {
        return output;
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
