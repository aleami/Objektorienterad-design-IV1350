package se.kth.iv1350.repairelectricbike.integration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.repairelectricbike.model.RepairOrder;
import se.kth.iv1350.repairelectricbike.model.dto.RepairOrderDTO;

import java.util.List;

/**
 * Unit tests for the RepairOrderRegistry class.
 */
public class RepairOrderRegistryTest {

    private RepairOrderRegistry repairOrderRegistry;

    @BeforeEach
    public void setUp() {
        repairOrderRegistry = new RepairOrderRegistry();
    }

    @Test
    public void testFindRepairOrderReturnsNullWhenEmpty() {
        RepairOrder result = repairOrderRegistry.findRepairOrder(1);
        assertNull(result,
                "findRepairOrder should return null when no orders have been added.");
    }

    @Test
    public void testCreateAndFindRepairOrder() {
        RepairOrder order = new RepairOrder(1, "Brake problem.");
        repairOrderRegistry.createRepairOrder(order);
        RepairOrder found = repairOrderRegistry.findRepairOrder(1);
        assertNotNull(found,
                "findRepairOrder should return the order after it has been created.");
        assertEquals(1, found.getId(),
                "Found order should have the same id as the created one.");
    }

    @Test
    public void testFindAllRepairOrdersIsEmptyInitially() {
        List<RepairOrderDTO> result = repairOrderRegistry.findAllRepairOrders();
        assertEquals(0, result.size(),
                "A new registry should contain zero repair orders.");
    }

    @Test
    public void testFindAllRepairOrdersReturnsAllCreated() {
        repairOrderRegistry.createRepairOrder(new RepairOrder(1, "Problem 1."));
        repairOrderRegistry.createRepairOrder(new RepairOrder(2, "Problem 2."));
        List<RepairOrderDTO> result = repairOrderRegistry.findAllRepairOrders();
        assertEquals(2, result.size(),
                "findAllRepairOrders should return exactly as many orders as were created.");
    }

    @Test
    public void testUpdateRepairOrderChangesState() {
        RepairOrder order = new RepairOrder(1, "Chain slips.");
        repairOrderRegistry.createRepairOrder(order);
        order.setState("ACCEPTED");
        repairOrderRegistry.updateRepairOrder(order);
        RepairOrder updated = repairOrderRegistry.findRepairOrder(1);
        assertEquals("ACCEPTED", updated.getState(),
                "State should be updated in registry after updateRepairOrder is called.");
    }
}