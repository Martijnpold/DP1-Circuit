package com.mpolder.dp1.ui;

import com.mpolder.dp1.CircuitSimulator;
import com.mpolder.dp1.circuit.Circuit;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class UIFrame extends JFrame {
    private UIPanel uiPanel;

    public UIFrame(Circuit circuit) {
        super();
        setTitle("Circuit Viewer");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        uiPanel = new UIPanel(circuit);
        setContentPane(uiPanel);
        pack();

        JFrame frame = this;
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == 'r') {
                    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    new CircuitSimulator().simulate();
                }
            }
        });
    }

    public UIPanel getUiPanel() {
        return uiPanel;
    }
}
