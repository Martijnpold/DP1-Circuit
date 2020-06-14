package com.mpolder.dp1.parse;

import com.mpolder.dp1.exception.CircuitFormatException;
import com.mpolder.dp1.gate.IGate;
import com.mpolder.dp1.gate.IGateFactory;

import java.io.IOException;
import java.util.List;

public interface ICircuitParser {
    List<IGate> parse(IGateFactory gateFactory, List<String> lines) throws IOException, CircuitFormatException;
}
