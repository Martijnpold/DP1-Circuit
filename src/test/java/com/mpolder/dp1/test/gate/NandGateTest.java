package com.mpolder.dp1.test.gate;

import com.mpolder.dp1.circuit.Circuit;
import com.mpolder.dp1.circuit.CircuitBuilder;
import com.mpolder.dp1.gate.InputGate;
import com.mpolder.dp1.gate.ProbeGate;
import com.mpolder.dp1.parse.FileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class NandGateTest {
    private Circuit c;
    private InputGate in1;
    private InputGate in2;
    private ProbeGate out;

    @BeforeEach
    public void setup() {
        CircuitBuilder cb = new CircuitBuilder();
        cb.setReader(new FileReader(new File("test-circuits/gate/g4_nand.txt")));
        c = cb.build();

        assertNotNull(c);

        in1 = (InputGate) c.getGates().stream().filter(o -> o.getId().equals("A")).findFirst().orElse(null);
        in2 = (InputGate) c.getGates().stream().filter(o -> o.getId().equals("B")).findFirst().orElse(null);
        out = c.getOutputs().get(0);

        assertNotNull(in1);
        assertNotNull(in2);
        assertNotNull(out);
    }

    @Test
    public void test_gate_and_both_off() {
        in1.setOutput(false);
        in2.setOutput(false);
        c.resetState();
        assertTrue(out.getOutput());
    }

    @Test
    public void test_gate_and_both_on() {
        in1.setOutput(true);
        in2.setOutput(true);
        c.resetState();
        assertFalse(out.getOutput());
    }

    @Test
    public void test_gate_and_one_on() {
        in1.setOutput(true);
        in2.setOutput(false);
        c.resetState();
        assertTrue(out.getOutput());
    }
}
