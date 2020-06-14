package com.mpolder.dp1.test.circuit;

import com.mpolder.dp1.circuit.Circuit;
import com.mpolder.dp1.circuit.CircuitBuilder;
import com.mpolder.dp1.exception.CircuitFormatException;
import com.mpolder.dp1.exception.CircuitLoopException;
import com.mpolder.dp1.exception.CircuitNodeDetachedException;
import com.mpolder.dp1.gate.GateFactory;
import com.mpolder.dp1.gate.ProbeGate;
import com.mpolder.dp1.parse.FileReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

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
    public void should_throw_infiniteloop() {
        CircuitBuilder cb = new CircuitBuilder();
        cb.setReader(new FileReader(new File("test-circuits/full/c4_infiniteloop.txt")));
        assertThrows(CircuitLoopException.class, cb::build);
    }

    @Test
    public void should_throw_notconnected() {
        CircuitBuilder cb = new CircuitBuilder();
        cb.setReader(new FileReader(new File("test-circuits/full/c5_notconnected.txt")));
        assertThrows(CircuitNodeDetachedException.class, cb::build);
    }

    @Test
    public void should_throw_filenotfound() {
        CircuitBuilder cb = new CircuitBuilder();
        cb.setReader(new FileReader(new File("test-circuits/full/non_existing_circuit.txt")));
        assertThrows(CircuitFormatException.class, cb::build);
    }

    @Test
    public void should_replace_parts() {
        CircuitBuilder cb = new CircuitBuilder();
        AtomicBoolean one = new AtomicBoolean();
        AtomicBoolean two = new AtomicBoolean();
        AtomicBoolean three = new AtomicBoolean();

        cb.setGateFactory((type, id) -> {
            three.set(true);
            return new GateFactory().create(type, id);
        });
        cb.setParser((gateFactory, lines) -> {
            one.set(true);
            return Collections.singletonList(gateFactory.create("INPUT_HIGH", "id"));
        });
        cb.setReader(() -> {
            two.set(true);
            return Collections.emptyList();
        });
        cb.setStrategy((exception) -> {
        });

        cb.build();
        assertTrue(one.get());
        assertTrue(two.get());
        assertTrue(three.get());
    }
}
