package se.kth.iv1350.repairelectricbike.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the RepairOrder class.
 */
public class RepairOrderTest {

    private RepairOrder order;

    @BeforeEach
    void setUp() {
        order = new RepairOrder(1, "Battery problem");
    }

    @Test
    void testConstructor() {
        assertEquals("NEWLY CREATED", order.getState(),
                "A newly created repair order should have state NEWLY CREATED.");
        assertEquals(1, order.getId(),
                "getId should return the id set in the constructor.");
        assertEquals("Battery problem", order.getProblemDesc(),
                "getProblemDesc should return the description set in the constructor.");
    }

    @Test
    void testOnAddRepairTask() {
        order.addRepairTask("Replace chain");
        assertTrue(order.toString().contains("Replace chain"),
                "Added repair task should appear in toString output.");
    }

    @Test
    void testOnAddDiagnosticResult() {
        order.addDiagnosticResult(1, "Motor is broken");
        assertTrue(order.toString().contains("Motor is broken"),
                "Added diagnostic result should appear in toString output.");
    }

    @Test
    void testOnSetStateAccepted() {
        order.setState("ACCEPTED");
        assertEquals("ACCEPTED", order.getState(),
                "State should be ACCEPTED after calling setState(ACCEPTED).");
    }

    @Test
    void testOnSetStateRejected() {
        order.setState("REJECTED");
        assertEquals("REJECTED", order.getState(),
                "State should be REJECTED after calling setState(REJECTED).");
    }
}