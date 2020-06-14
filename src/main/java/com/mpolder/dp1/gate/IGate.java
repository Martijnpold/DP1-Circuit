package com.mpolder.dp1.gate;

import com.mpolder.dp1.circuit.Circuit;
import com.mpolder.dp1.exception.CircuitFormatException;

import java.util.ArrayList;
import java.util.List;

public abstract class IGate {
    private String id;
    protected List<IGate> outputs;

    public IGate(String id) {
        this.id = id;
        outputs = new ArrayList<>();
    }

    public boolean getOutput() {
        return calculateOutput();
    }

    abstract boolean calculateOutput();

    public abstract void attachInput(IGate gate) throws CircuitFormatException;

    protected void attachOutput(IGate gate) {
        outputs.add(gate);
    }

    public void attachCircuit(Circuit circuit) {
        //No default
    }

    public void toggle() {
        //No default
    }

    public boolean requiresOutput() {
        return true;
    }

    public abstract boolean validateInput();

    public boolean validateOutput() {
        if(!requiresOutput()) return true;
        return outputs.size() > 0;
    }

    public boolean validate() {
        return validateInput() && validateOutput();
    }

    public abstract IGate cloneGate(String id);

    public String getId() {
        return id;
    }

    public List<IGate> getOutputs() {
        return outputs;
    }
}
