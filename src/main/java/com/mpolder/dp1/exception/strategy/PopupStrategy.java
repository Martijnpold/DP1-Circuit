package com.mpolder.dp1.exception.strategy;

import javax.swing.*;

public class PopupStrategy implements IExceptionStrategy {
    @Override
    public void execute(Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
