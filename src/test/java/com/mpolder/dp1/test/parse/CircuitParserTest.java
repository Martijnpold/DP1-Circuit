package com.mpolder.dp1.test.parse;

import com.mpolder.dp1.gate.GateFactory;
import com.mpolder.dp1.gate.IGate;
import com.mpolder.dp1.parse.CircuitParser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircuitParserTest {
    @Test
    public void test_should_build_gates() {
        List<String> lines = Arrays.asList(
                "A:INPUT_HIGH",
                "Cout:PROBE"
        );

        CircuitParser parser = new CircuitParser();
        List<IGate> gates = parser.parse(new GateFactory(), lines);

        assertEquals(2, gates.size());
        assertTrue(gates.stream().anyMatch(o -> o.getId().equals("A") && o.getClass().getSimpleName().equals("InputGate")));
        assertTrue(gates.stream().anyMatch(o -> o.getId().equals("Cout") && o.getClass().getSimpleName().equals("ProbeGate")));
    }

    @Test
    public void test_should_connect_gates() {
        List<String> lines = Arrays.asList(
                "A:INPUT_HIGH",
                "Cout:PROBE",
                "A:Cout"
        );

        CircuitParser parser = new CircuitParser();
        List<IGate> gates = parser.parse(new GateFactory(), lines);

        assertEquals(2, gates.size());
        assertTrue(gates.stream().anyMatch(o -> o.getId().equals("A") && o.getClass().getSimpleName().equals("InputGate")));
        assertTrue(gates.stream().anyMatch(o -> o.getId().equals("Cout") && o.getClass().getSimpleName().equals("ProbeGate")));
        assertTrue(gates.stream().anyMatch(o ->
                o.getId().equals("A") && o.getClass().getSimpleName().equals("InputGate")
                        && o.getOutputs().size() == 1
                        && o.getOutputs().get(0).getId().equals("Cout")
        ));
    }
}
