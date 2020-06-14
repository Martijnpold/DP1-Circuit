package com.mpolder.dp1.gate.ui;

import com.mpolder.dp1.circuit.Circuit;

import javax.swing.*;

public class UIFrame extends JFrame {
    private UIPanel uiPanel;

    public UIFrame(Circuit circuit) {
        super();
        setTitle("Circuit Viewer");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        uiPanel = new UIPanel(circuit);
        setContentPane(uiPanel);
        pack();
    }
}
