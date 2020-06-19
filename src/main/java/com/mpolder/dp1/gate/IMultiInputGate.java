package com.mpolder.dp1.gate;

import java.util.ArrayList;
import java.util.List;

public abstract class IMultiInputGate extends IGate {
    protected List<IGate> inputs;

    public IMultiInputGate(String id) {
        super(id);
        inputs = new ArrayList<>();
    }

    @Override
    public void attachInput(IGate gate) {
        gate.attachOutput(this);
        inputs.add(gate);
    }

    @Override
    protected boolean validateInput() {
        return inputs.size() > 0;
    }

    protected int combinedInputs() {
        return inputs.stream().map(IGate::getOutput).mapToInt(x -> x ? 1 : 0).sum();
    }
}
