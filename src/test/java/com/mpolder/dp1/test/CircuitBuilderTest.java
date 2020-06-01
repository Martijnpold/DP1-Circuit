package com.mpolder.dp1.test;

import com.mpolder.circuit.Circuit;
import com.mpolder.circuit.CircuitBuilder;
import com.mpolder.exception.CircuitLoopException;
import com.mpolder.exception.CircuitNodeDetachedException;
import com.mpolder.gate.ProbeGate;
import com.mpolder.parse.FileReader;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class CircuitBuilderTest {
    @Test
    public void should_return_fulladder() {
        CircuitBuilder cb = new CircuitBuilder();
        cb.setReader(new FileReader(new File("test-circuits/full/c1_fulladder.txt")));
        Circuit c = cb.build();
        assertNotNull(c);
        for (ProbeGate gate : c.getOutputs()) {
            assertDoesNotThrow(gate::getOutput);
        }
    }

    @Test
    public void should_return_decoder() {
        CircuitBuilder cb = new CircuitBuilder();
        cb.setReader(new FileReader(new File("test-circuits/full/c2_decoder.txt")));
        Circuit c = cb.build();
        assertNotNull(c);
        for (ProbeGate gate : c.getOutputs()) {
            assertDoesNotThrow(gate::getOutput);
        }
    }

    @Test
    public void should_return_encoder() {
        CircuitBuilder cb = new CircuitBuilder();
        cb.setReader(new FileReader(new File("test-circuits/full/c3_encoder.txt")));
        Circuit c = cb.build();
        assertNotNull(c);
        for (ProbeGate gate : c.getOutputs()) {
            assertDoesNotThrow(gate::getOutput);
        }
    }

    @Test
    public void should_return_infiniteloop() {
        CircuitBuilder cb = new CircuitBuilder();
        cb.setReader(new FileReader(new File("test-circuits/full/c4_infiniteloop.txt")));
        Circuit c = cb.build();
        assertNotNull(c);
        for (ProbeGate gate : c.getOutputs()) {
            assertThrows(CircuitLoopException.class, gate::getOutput);
        }
    }

    @Test
    public void should_return_notconnected() {
        CircuitBuilder cb = new CircuitBuilder();
        cb.setReader(new FileReader(new File("test-circuits/full/c5_notconnected.txt")));
        assertThrows(CircuitNodeDetachedException.class, cb::build);
    }
}
