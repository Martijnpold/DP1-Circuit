package com.mpolder.dp1.gate.state;

import com.mpolder.dp1.gate.IGate;

public class UnknownState implements INodeState {
    @Override
    public boolean value(IGate gate) {
        if (gate.calculateOutput()) {
            gate.transferState(new OnState());
        } else {
            gate.transferState(new OffState());
        }
        return gate.getOutput();
    }
}
