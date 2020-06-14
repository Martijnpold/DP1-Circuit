package com.mpolder.dp1.test.ui;

import com.mpolder.dp1.circuit.Circuit;
import com.mpolder.dp1.circuit.CircuitBuilder;
import com.mpolder.dp1.parse.CircuitFileSelector;
import com.mpolder.dp1.parse.FileReader;
import com.mpolder.dp1.ui.UIFrame;
import com.mpolder.dp1.ui.UIPanel;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class UITest {
    @Test
    public void should_build_gates() {
        CircuitBuilder cb = new CircuitBuilder();
        cb.setReader(new FileReader(new File("test-circuits/full/c1_fulladder.txt")));
        Circuit c = cb.build();
        assertNotNull(c);

        UIFrame frame = new UIFrame(c);
        assertNotNull(frame.getUiPanel());
        UIPanel panel = frame.getUiPanel();
        frame.setVisible(true);

        assertNull(panel.getDrag());
        panel.getDragDropMouseListener().mousePressed(new MouseEvent(panel, 1, System.currentTimeMillis(), 0, 50, 50, 1, false, 1));
        assertNotNull(panel.getDrag());
        int y = panel.getDrag().getY();
        panel.getDragDropMouseListener().mouseDragged(new MouseEvent(panel, 1, System.currentTimeMillis(), 0, 50, 60, 1, false, 1));
        assertEquals(y + 10, panel.getDrag().getY());
        panel.getDragDropMouseListener().mouseReleased(new MouseEvent(panel, 1, System.currentTimeMillis(), 0, 50, 50, 1, false, 1));
        assertNull(panel.getDrag());
        panel.getDragDropMouseListener().mousePressed(new MouseEvent(panel, 1, System.currentTimeMillis(), 0, 50, 50, 1, false, 3));
    }

    @Test
    public void show_selector() throws Exception {
        CircuitFileSelector cfs = new CircuitFileSelector();
        Thread t = new Thread(cfs::select);
        t.start();
        Thread.sleep(50);
        assertTrue(t.isAlive());
    }
}
