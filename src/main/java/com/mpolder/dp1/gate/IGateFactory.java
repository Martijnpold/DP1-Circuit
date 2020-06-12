package com.mpolder.dp1.gate;

import com.mpolder.dp1.exception.CircuitNodeTypeNotFoundException;

public interface IGateFactory {
    IGate create(String gate, String id) throws CircuitNodeTypeNotFoundException;
}
