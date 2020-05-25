package com.mpolder.circuit;

import com.mpolder.exception.CircuitFormatException;
import com.mpolder.gate.GateFactory;
import com.mpolder.gate.IGate;
import com.mpolder.gate.IGateFactory;
import com.mpolder.parse.CircuitParser;
import com.mpolder.parse.FileReader;
import com.mpolder.parse.ICircuitParser;
import com.mpolder.parse.IReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CircuitBuilder {
    private IReader reader;
    private IGateFactory gateFactory;
    private ICircuitParser circuitParser;

    public CircuitBuilder() {
        reader = new FileReader(new File("circuit.txt"));
        gateFactory = new GateFactory();
        circuitParser = new CircuitParser(reader, gateFactory);
    }

    public Circuit build() {
        try {
            List<IGate> gates = circuitParser.parse();
            Circuit c = new Circuit();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Could not construct a valid circuit using the given parameters");
        }
        return null;
    }

    public void setReader(IReader reader) {
        this.reader = reader;
        circuitParser = new CircuitParser(reader, gateFactory);
    }

    public void setGateFactory(IGateFactory gateFactory) {
        this.gateFactory = gateFactory;
        circuitParser = new CircuitParser(reader, gateFactory);
    }
}
