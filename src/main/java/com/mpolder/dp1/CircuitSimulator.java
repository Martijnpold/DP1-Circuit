package com.mpolder.dp1;

import com.mpolder.dp1.circuit.Circuit;
import com.mpolder.dp1.circuit.CircuitBuilder;
import com.mpolder.dp1.gate.ui.UIFrame;
import com.mpolder.dp1.parse.CircuitFileSelector;
import com.mpolder.dp1.parse.FileReader;

import java.io.File;

public class CircuitSimulator {
    public void simulate() {
        CircuitFileSelector selector = new CircuitFileSelector();
        File file = selector.select();
        if(file != null) {
            CircuitBuilder builder = new CircuitBuilder();
            builder.setReader(new FileReader(file));
            Circuit circuit = builder.build();
            UIFrame frame = new UIFrame(circuit);
            frame.setVisible(true);
        }
    }
}