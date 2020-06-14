package com.mpolder.dp1.ui;

import com.mpolder.dp1.gate.IGate;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class UIGate {
    private IGate gate;
    private int x, y, size;

    public static final int DEFAULT_SIZE = 60;

    public UIGate(IGate gate) {
        this.gate = gate;
        this.size = DEFAULT_SIZE;
        this.x = this.size / 2;
        this.y = this.size / 2;
    }

    public void toggle() {
        gate.toggle();
    }

    public boolean isAt(int x2, int y2) {
        return x2 >= x && y2 >= y && x2 <= x + this.size && y2 <= y + this.size;
    }

    public String getId() {
        return gate.getId();
    }

    public List<String> getConnectedIds() {
        return gate.getOutputs().stream().map(IGate::getId).collect(Collectors.toList());
    }

    public String getLabel() {
        return gate.getClass().getSimpleName().replace("Gate", "");
    }

    public boolean getOutput() {
        return gate.getOutput();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    /**
     * Calculate rectangle on UIGate for labels
     *
     * @param id Index of label
     * @param of Total labels
     * @return Rectangle representing the label space
     */
    public Rectangle drawSlot(int id, int of) {
        return new Rectangle(x, y + size / of * id, size, size / of);
    }
}
