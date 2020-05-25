package com.mpolder.parse;

import com.mpolder.exception.CircuitFormatException;
import com.mpolder.gate.IGate;

import java.io.IOException;
import java.util.List;

public interface ICircuitParser {
    List<IGate> parse() throws IOException, CircuitFormatException;
}
