package com.mpolder.gate;

import com.mpolder.circuit.Circuit;
import com.mpolder.exception.CircuitFormatException;

public abstract class IGate {
    public abstract boolean getOutput() throws CircuitFormatException;

    public abstract void attachOutput(IGate gate);

    public abstract void attachCircuit(Circuit circuit);

    public abstract boolean validate();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
