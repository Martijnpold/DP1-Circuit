package com.mpolder.dp1.test.gate;

import com.mpolder.dp1.exception.CircuitNodeTypeNotFoundException;
import com.mpolder.dp1.gate.GateFactory;
import com.mpolder.dp1.gate.IGate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GateFactoryTest {
    @Test
    public void test_should_build_gate() {
        String expectedId = "TestId";

        GateFactory factory = new GateFactory();
        IGate actual = factory.create("AND", expectedId);

        assertEquals(expectedId, actual.getId());
        assertEquals("AndGate", actual.getClass().getSimpleName());
    }

    @Test
    public void test_should_throw_node_type_not_found() {
        GateFactory factory = new GateFactory();
        assertThrows(CircuitNodeTypeNotFoundException.class, () -> factory.create("INVALID_ID", "id"));
    }
}
