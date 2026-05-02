package se.kth.iv1350.repairelectricbike.view;

import java.util.List;

import se.kth.iv1350.repairelectricbike.controller.Controller; 
import se.kth.iv1350.repairelectricbike.model.dto.CustomerDTO; 
import se.kth.iv1350.repairelectricbike.model.dto.RepairOrderDTO;

/**
 * Represents the user interface.
 */
public class View {

    private final Controller controller;

    /**
     * Creates a new view.
     *
     * @param controller Used to communicate with the system.
     */
    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * Runs the program.
     */
    public void run() {
        findCustomerStep();
        createRepairOrderStep();
        findAllRepairOrdersStep();
        addDiagnosticResultStep();
        addRepairTaskStep();
        acceptRepairOrderStep();
    }

    /**
     * Finds a customer and prints the result.
     */
    private void findCustomerStep() {
        System.out.println("1. Find customer");

        CustomerDTO customer = controller.findCustomer("0701234567");

        if (customer != null) {
            System.out.println("   Customer found: " + customer.getName());
        } else {
            System.out.println("   Customer not found.");
        }
    }

    /**
     * Creates a repair order.
     */
    private void createRepairOrderStep() {
        System.out.println("2. Create repair order");

        controller.createRepairOrder("Battery dead", "0701234567", 12345);

        System.out.println("   Repair order created.");
    }

    /**
     * Gets and prints all repair orders.
     */
    private void findAllRepairOrdersStep() {
        System.out.println("3. Find all repair orders");

        List<RepairOrderDTO> orders = controller.findAllRepairOrders();

        for (RepairOrderDTO order : orders) {
            System.out.println(
                    "   ID: " + order.id +
                    ", Date: " + order.date +
                    ", Problem: " + order.problemDesc +
                    ", State: " + order.state
            );
        }
    }

    /**
     * Adds a diagnostic result.
     */
    private void addDiagnosticResultStep() {
        System.out.println("4. Add diagnostic result");

        controller.addDiagnosticResult(1, "Replace dead battery");

        System.out.println("   Diagnostic result added.");
    }

    /**
     * Adds a repair task.
     */
    private void addRepairTaskStep() {
        System.out.println("5. Add repair task");

        controller.addRepairTask(1, "Replace battery");

        System.out.println("   Repair task added.");
    }

    /**
     * Accepts a repair order.
     */
    private void acceptRepairOrderStep() {
        System.out.println("6. Accept repair order\n");

        controller.acceptRepairOrder(1);

        System.out.println("   Repair order accepted.");
    }
}