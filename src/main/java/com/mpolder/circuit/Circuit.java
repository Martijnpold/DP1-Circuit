package com.mpolder.circuit;

import com.mpolder.gate.IGate;
import com.mpolder.gate.InputGate;
import com.mpolder.gate.ProbeGate;

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

    public List<ProbeGate> getOutputs() {
        return outputs;
    }
}
