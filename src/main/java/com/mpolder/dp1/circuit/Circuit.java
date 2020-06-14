package com.mpolder.dp1.circuit;

import com.mpolder.dp1.gate.IGate;
import com.mpolder.dp1.gate.InputGate;
import com.mpolder.dp1.gate.ProbeGate;
import com.mpolder.dp1.gate.state.UnknownState;

import java.util.ArrayList;
import java.util.List;

public class Circuit {
    private List<IGate> gates;
    private List<InputGate> inputs;
    private List<ProbeGate> outputs;

    public Circuit() {
        gates = new ArrayList<>();
        inputs = new ArrayList<>();
        outputs = new ArrayList<>();
    }

    public void resetState() {
        for(IGate gate : gates) gate.transferState(new UnknownState());
    }

    public void attachGate(IGate gate) {
        gate.attachCircuit(this);
        gates.add(gate);
    }

    public void attachInput(InputGate gate) {
        inputs.add(gate);
    }

    public void attachOutput(ProbeGate gate) {
        outputs.add(gate);
    }

    public List<IGate> getGates() {
        return gates;
    }

    public List<ProbeGate> getOutputs() {
        return outputs;
    }
}
