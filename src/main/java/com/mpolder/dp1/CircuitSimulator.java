package com.mpolder.dp1;

import com.mpolder.dp1.circuit.Circuit;
import com.mpolder.dp1.circuit.CircuitBuilder;
import com.mpolder.dp1.exception.strategy.PopupStrategy;
import com.mpolder.dp1.ui.UIFrame;
import com.mpolder.dp1.parse.CircuitFileSelector;
import com.mpolder.dp1.parse.FileReader;

import java.io.File;

public class CircuitSimulator {
    public void simulate() {
        CircuitFileSelector selector = new CircuitFileSelector();
        File file = selector.select();
        if(file != null) {
            CircuitBuilder builder = new CircuitBuilder();
            builder.setStrategy(new PopupStrategy());
            builder.setReader(new FileReader(file));
            Circuit circuit = builder.build();
            UIFrame frame = new UIFrame(circuit);
            frame.setVisible(true);
        }
    }
}
