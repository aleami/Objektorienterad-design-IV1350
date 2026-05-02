
package se.kth.iv1350.repairelectricbike.integration;
import se.kth.iv1350.repairelectricbike.integration.CustomerRegistry;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderRegistry;


/**
 * This class is responsible for creating the customer and repair order registry and its dependencies.
 */
public class RegistryCreator {
    private CustomerRegistry customerRegistry;
    private RepairOrderRegistry repairOrderRegistry;

    /**
     * Creates the registry and its dependencies.
     */
    public RegistryCreator() {
        customerRegistry = new CustomerRegistry();
        repairOrderRegistry = new RepairOrderRegistry();  
    }

    /**
     * @return The customer registry.
     */
    public CustomerRegistry getCustomerRegistry() {
        return customerRegistry;
    }

    /**
     * @return The repair order registry.
     */
    public RepairOrderRegistry getRepairOrderRegistry() {
        return repairOrderRegistry;
    }
}