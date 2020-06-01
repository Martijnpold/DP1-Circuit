package com.mpolder.gate;

import com.mpolder.circuit.Circuit;
import com.mpolder.exception.CircuitFormatException;

import java.util.ArrayList;
import java.util.List;

public abstract class IGate {
    private String id;
    protected Boolean output;
    protected List<IGate> outputs;

    public IGate(String id) {
        this.id = id;
        outputs = new ArrayList<>();
    }

    public boolean getOutput() {
        if (output == null) {
            output = calculateOutput();
        }
        return output;
    }

    abstract boolean calculateOutput();

    public abstract void attachInput(IGate gate) throws CircuitFormatException;

    protected void attachOutput(IGate gate) {
        outputs.add(gate);
    }

    public void attachCircuit(Circuit circuit) {
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
