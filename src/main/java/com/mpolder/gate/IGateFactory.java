package com.mpolder.gate;

import com.mpolder.exception.CircuitNodeTypeNotFoundException;

public interface IGateFactory {
    IGate create(String gate) throws CircuitNodeTypeNotFoundException;
}
