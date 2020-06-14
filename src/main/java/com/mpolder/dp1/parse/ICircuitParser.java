package com.mpolder.dp1.parse;

import com.mpolder.dp1.exception.CircuitFormatException;
import com.mpolder.dp1.gate.IGate;
import com.mpolder.dp1.gate.IGateFactory;

import java.io.IOException;
import java.util.List;

public interface ICircuitParser {
    /**
     * Parse given lines using the gatefactory provided
     *
     * @param gateFactory gate factory to fetch gates from
     * @param lines       lines to use as input
     * @return constructed gates
     */
    List<IGate> parse(IGateFactory gateFactory, List<String> lines) throws IOException, CircuitFormatException;
}
