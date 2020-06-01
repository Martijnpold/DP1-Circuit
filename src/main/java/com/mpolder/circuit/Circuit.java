package com.mpolder.circuit;

import com.mpolder.gate.IGate;
import com.mpolder.gate.ProbeGate;

import java.util.ArrayList;
import java.util.List;

public class Circuit {
    private List<IGate> gates;
    private List<ProbeGate> output;

    public Circuit() {
        gates = new ArrayList<>();
        output = new ArrayList<>();
    }

    public void attachGate(IGate gate) {
        gate.attachCircuit(this);
        gates.add(gate);
    }

    public void attachOutput(ProbeGate gate) {
        output.add(gate);
    }
}
