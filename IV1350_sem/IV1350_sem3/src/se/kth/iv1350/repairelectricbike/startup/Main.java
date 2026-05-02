package se.kth.iv1350.repairelectricbike.startup;

import se.kth.iv1350.repairelectricbike.integration.RegistryCreator;
import se.kth.iv1350.repairelectricbike.integration.Printer;
import se.kth.iv1350.repairelectricbike.controller.Controller;
import se.kth.iv1350.repairelectricbike.view.View;

/**
 * Starts the system.
 */
public class Main {

    /**
     * Starts the application.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {

        // 1. Create registry creator
        RegistryCreator registryCreator = new RegistryCreator();

        // 2. Create printer
        Printer printer = new Printer();

        // 3. Create controller
        Controller controller = new Controller(registryCreator, printer);

        // 4. Create view
        View view = new View(controller);

        // 5. Start system
        view.run();
    }
}