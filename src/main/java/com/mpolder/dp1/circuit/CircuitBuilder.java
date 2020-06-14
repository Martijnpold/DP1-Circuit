package com.mpolder.dp1.circuit;

import com.mpolder.dp1.exception.CircuitFormatException;
import com.mpolder.dp1.exception.CircuitLoopException;
import com.mpolder.dp1.exception.CircuitNodeDetachedException;
import com.mpolder.dp1.gate.GateFactory;
import com.mpolder.dp1.gate.IGate;
import com.mpolder.dp1.gate.IGateFactory;
import com.mpolder.dp1.gate.ProbeGate;
import com.mpolder.dp1.parse.CircuitParser;
import com.mpolder.dp1.parse.FileReader;
import com.mpolder.dp1.parse.ICircuitParser;
import com.mpolder.dp1.parse.IReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CircuitBuilder {
    private IReader reader;
    private IGateFactory gateFactory;
    private ICircuitParser circuitParser;

    public CircuitBuilder() {
        reader = new FileReader(new File("circuit.txt"));
        gateFactory = new GateFactory();
        circuitParser = new CircuitParser();
    }

    /**
     * Build a circuit using the given circuitparser, reader and gatefactory
     *
     * @return Constructed circuit
     * @throws CircuitFormatException when the given circuit is invalid
     */
    public Circuit build() throws CircuitFormatException {
        try {
            List<IGate> gates = circuitParser.parse(gateFactory, reader.read());
            Circuit c = new Circuit();
            for (IGate gate : gates) c.attachGate(gate);
            validateOutput(c);
            return c;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CircuitFormatException e) {
            System.out.println("Could not construct a valid circuit using the given parameters");
            System.out.println("Reason: " + e.getMessage());
            throw e;
        }
        return null;
    }

    private void validateOutput(Circuit circuit) {
        for (IGate gate : circuit.getGates()) {
            if (!gate.validate()) {
                throw new CircuitNodeDetachedException("The gate " + gate.getId() + " is not attached properly");
            }
        }
        for (ProbeGate out : circuit.getOutputs()) {
            try {
                out.getOutput();
            } catch (StackOverflowError e) {
                throw new CircuitLoopException("An infinite loop was detected in the circuit");
            }
        }
    }

    public void setReader(IReader reader) {
        this.reader = reader;
    }

    public void setGateFactory(IGateFactory gateFactory) {
        this.gateFactory = gateFactory;
    }

    public void setParser(ICircuitParser parser) {
        this.circuitParser = parser;
    }
}
