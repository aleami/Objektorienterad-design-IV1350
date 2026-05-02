package se.kth.iv1350.repairelectricbike.controller;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.repairelectricbike.integration.Printer;
import se.kth.iv1350.repairelectricbike.integration.RegistryCreator;
import se.kth.iv1350.repairelectricbike.model.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.model.dto.RepairOrderDTO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Controller class.
 */
public class ControllerTest {

    private Controller controller;

    // Telefonnummer som finns i CustomerRegistry
    private static final String EXISTING_PHONE = "01234";       
    private static final String NONEXISTENT_PHONE = "0000000000";

    @BeforeEach
    public void setUp() {
        RegistryCreator registryCreator = new RegistryCreator();
        Printer printer = new Printer();
        controller = new Controller(registryCreator, printer);
    }

    @Test
    public void testFindCustomerReturnsCustomerForExistingPhone() {
        CustomerDTO result = controller.findCustomer(EXISTING_PHONE);
        assertNotNull(result,
                "findCustomer should return a CustomerDTO for an existing phone number.");
    }

    @Test
    public void testFindCustomerReturnsNullForUnknownPhone() {
        CustomerDTO result = controller.findCustomer(NONEXISTENT_PHONE);
        assertNull(result,
                "findCustomer should return null for an unknown phone number.");
    }

    @Test
    public void testCreateRepairOrderAppearsInFindAll() {
        controller.createRepairOrder("Brake problem.", EXISTING_PHONE, 1);
        List<RepairOrderDTO> orders = controller.findAllRepairOrders();
        assertEquals(1, orders.size(),
                "After creating one repair order, findAllRepairOrders should return one.");
    }

    @Test
    public void testFindAllRepairOrdersIsEmptyBeforeAnyCreated() {
        List<RepairOrderDTO> orders = controller.findAllRepairOrders();
        assertEquals(0, orders.size(),
                "Before any repair orders are created, findAllRepairOrders should return empty.");
    }

    @Test
    public void testAcceptRepairOrderChangesStateToAccepted() {
        controller.createRepairOrder("Wheel wobbles.", EXISTING_PHONE, 1);
        int orderId = controller.findAllRepairOrders().get(0).id;
        controller.acceptRepairOrder(orderId);
        assertEquals("ACCEPTED", controller.findAllRepairOrders().get(0).state,
                "State should be ACCEPTED after acceptRepairOrder is called.");
    }

    @Test
    public void testRejectRepairOrderChangesStateToRejected() {
        controller.createRepairOrder("Display broken.", EXISTING_PHONE, 1);
        int orderId = controller.findAllRepairOrders().get(0).id;
        controller.rejectRepairOrder(orderId);
        assertEquals("REJECTED", controller.findAllRepairOrders().get(0).state,
                "State should be REJECTED after rejectRepairOrder is called.");
    }

    @Test
    public void testAddRepairTaskDoesNotThrow() {
        controller.createRepairOrder("Motor noise.", EXISTING_PHONE, 1);
        int orderId = controller.findAllRepairOrders().get(0).id;
        assertDoesNotThrow(() -> controller.addRepairTask(orderId, "Replace motor."),
                "addRepairTask should not throw any exception.");
    }

    @Test
    public void testAddDiagnosticResultDoesNotThrow() {
        controller.createRepairOrder("Strange noise.", EXISTING_PHONE, 1);
        int orderId = controller.findAllRepairOrders().get(0).id;
        assertDoesNotThrow(() -> controller.addDiagnosticResult(orderId, "Bearing worn."),
                "addDiagnosticResult should not throw any exception.");
    }
}