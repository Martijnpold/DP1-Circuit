package com.mpolder.dp1.parse;

import javax.swing.*;
import java.io.File;

public class CircuitFileSelector {
    private JFileChooser fc;

    public CircuitFileSelector() {
        fc = new JFileChooser();
        fc.setCurrentDirectory(new File("./"));
    }

    /**
     * Let the user select a file to parse
     *
     * @return Selected file
     */
    public File select() {
        int result = fc.showDialog(null, "open");
        if (result == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile();
        }
        return null;
    }

    public JFileChooser getFc() {
        return fc;
    }
}
