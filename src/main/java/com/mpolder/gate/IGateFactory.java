package com.mpolder.gate;

import com.mpolder.exception.CircuitNodeTypeNotFoundException;

public interface IGateFactory {
    IGate create(String gate, String id) throws CircuitNodeTypeNotFoundException;
}
