package com.mpolder.dp1.gate.state;

import com.mpolder.dp1.gate.IGate;

public class OffState implements INodeState {
    @Override
    public boolean value(IGate gate) {
        return false;
    }
}
