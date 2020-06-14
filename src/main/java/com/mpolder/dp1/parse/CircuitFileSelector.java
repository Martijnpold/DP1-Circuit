package com.mpolder.dp1.parse;

import javax.swing.*;
import java.io.File;

public class CircuitFileSelector {
    /**
     * Let the user select a file to parse
     *
     * @return Selected file
     */
    public File select() {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("./"));
        int result = fc.showDialog(null, "open");
        if (result == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile();
        }
        return null;
    }
}
