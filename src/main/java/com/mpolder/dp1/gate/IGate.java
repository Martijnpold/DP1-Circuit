package com.mpolder.dp1.gate;

import com.mpolder.dp1.circuit.Circuit;
import com.mpolder.dp1.exception.CircuitFormatException;
import com.mpolder.dp1.gate.state.INodeState;
import com.mpolder.dp1.gate.state.UnknownState;

import java.util.ArrayList;
import java.util.List;

public abstract class IGate {
    private String id;
    protected List<IGate> outputs;
    private INodeState state;

    public IGate(String id) {
        this.id = id;
        outputs = new ArrayList<>();
        state = new UnknownState();
    }

    public boolean getOutput() {
        return state.value(this);
    }

    public void transferState(INodeState newState) {
        this.state = newState;
    }

    public abstract boolean calculateOutput();

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

    protected boolean requiresOutput() {
        return true;
    }

    protected abstract boolean validateInput();

    protected boolean validateOutput() {
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
