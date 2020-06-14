package com.mpolder.dp1.gate.ui;

import com.mpolder.dp1.circuit.Circuit;
import com.mpolder.dp1.gate.IGate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class UIPanel extends JPanel {
    private HashMap<String, UIGate> gates;

    private UIGate drag;
    private Point dragOffset;

    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;

    public UIPanel(Circuit circuit) {
        super();
        gates = new HashMap<>();

        setBackground(Color.DARK_GRAY);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));

        loadCircuit(circuit);
    }

    public void loadCircuit(Circuit circuit) {
        addMouseListener(getMouseListener());
        addMouseMotionListener(getMouseListener());

        gates.clear();
        for (IGate gate : circuit.getGates()) {
            gates.put(gate.getId(), new UIGate(gate));
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (UIGate gate : gates.values()) {
            drawComponent(g, gate);
        }
    }

    public void drawComponent(Graphics g, UIGate gate) {
        g.setColor(Color.WHITE);
        g.fillRect(gate.getX(), gate.getY(), gate.getSize(), gate.getSize());
        g.setColor(Color.BLACK);
        g.drawRect(gate.getX(), gate.getY(), gate.getSize(), gate.getSize());
        drawCenteredString(g, gate.getLabel(), gate.drawSlot(0, 3), g.getFont());
        drawCenteredString(g, gate.getId(), gate.drawSlot(1, 3), g.getFont());
        drawCenteredString(g, gate.getOutput() + "", gate.drawSlot(2, 3), g.getFont());

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.RED);
        if (gate.getOutput()) g2.setColor(Color.GREEN);
        for (String conId : gate.getConnectedIds()) {
            UIGate con = gates.getOrDefault(conId, gate);
            g2.drawLine(gate.getX() + gate.getSize(), gate.getY() + gate.getSize() / 2, con.getX(), con.getY() + con.getSize() / 2);
        }
    }

    private MouseAdapter getMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == 1) {
                    for (UIGate gate : gates.values()) {
                        if (gate.isAt(e.getX(), e.getY())) {
                            drag = gate;
                            dragOffset = new Point(gate.getX() - e.getX(), gate.getY() - e.getY());
                        }
                    }
                }
                if(e.getButton() == 3) {
                    for (UIGate gate : gates.values()) {
                        if (gate.isAt(e.getX(), e.getY())) {
                            gate.toggle();
                            repaint();
                            return;
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                drag = null;
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if (drag != null && dragOffset != null) {
                    drag.setX((int) (e.getX() + dragOffset.getX()));
                    drag.setY((int) (e.getY() + dragOffset.getY()));
                    repaint();
                }
            }
        };
    }

    private void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setFont(font);
        g.drawString(text, x, y);
    }
}
