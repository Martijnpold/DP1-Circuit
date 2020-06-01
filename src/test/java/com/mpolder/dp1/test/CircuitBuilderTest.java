package com.mpolder.dp1.test;

import com.mpolder.circuit.CircuitBuilder;
import com.mpolder.exception.CircuitNodeDetachedException;
import com.mpolder.parse.FileReader;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CircuitBuilderTest {
    @Test
    public void should_return_fulladder() {
        CircuitBuilder cb = new CircuitBuilder();
        cb.setReader(new FileReader(new File("test-circuits/full/c1_fulladder.txt")));
        assertNotNull(cb.build());
    }

    @Test
    public void should_return_decoder() {
        CircuitBuilder cb = new CircuitBuilder();
        cb.setReader(new FileReader(new File("test-circuits/full/c2_decoder.txt")));
        assertNotNull(cb.build());
    }

    @Test
    public void should_return_encoder() {
        CircuitBuilder cb = new CircuitBuilder();
        cb.setReader(new FileReader(new File("test-circuits/full/c3_encoder.txt")));
        assertNotNull(cb.build());
    }

    @Test
    public void should_return_infiniteloop() {
        CircuitBuilder cb = new CircuitBuilder();
        cb.setReader(new FileReader(new File("test-circuits/full/c4_infiniteloop.txt")));
        assertNotNull(cb.build());
    }

    @Test
    public void should_return_notconnected() {
        CircuitBuilder cb = new CircuitBuilder();
        cb.setReader(new FileReader(new File("test-circuits/full/c5_notconnected.txt")));
        assertThrows(CircuitNodeDetachedException.class, cb::build);
    }
}
