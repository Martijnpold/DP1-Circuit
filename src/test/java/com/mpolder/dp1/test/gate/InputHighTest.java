package com.mpolder.dp1.test.gate;

import com.mpolder.dp1.circuit.Circuit;
import com.mpolder.dp1.circuit.CircuitBuilder;
import com.mpolder.dp1.gate.InputGate;
import com.mpolder.dp1.gate.ProbeGate;
import com.mpolder.dp1.parse.FileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputHighTest {
    private Circuit c;
    private InputGate in1;
    private ProbeGate out;

    @BeforeEach
    public void setup() {
        CircuitBuilder cb = new CircuitBuilder();
        cb.setReader(new FileReader(new File("test-circuits/gate/g3_input_high.txt")));
        c = cb.build();

        assertNotNull(c);

        in1 = (InputGate) c.getGates().stream().filter(o -> o.getId().equals("A")).findFirst().orElse(null);
        out = c.getOutputs().get(0);

        assertNotNull(in1);
        assertNotNull(out);
    }

    @Test
    public void test_gate() {
        in1.setOutput(true);
        c.resetState();
        assertTrue(out.getOutput());
    }
}
