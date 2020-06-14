package com.mpolder.dp1.gate.state;

import com.mpolder.dp1.gate.IGate;

public interface INodeState {
    boolean value(IGate gate);
}
