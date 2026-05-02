package se.kth.iv1350.repairelectricbike.controller;

import se.kth.iv1350.repairelectricbike.integration.CustomerRegistry;
import se.kth.iv1350.repairelectricbike.integration.Printer;
import se.kth.iv1350.repairelectricbike.integration.RegistryCreator;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairelectricbike.model.Customer;
import se.kth.iv1350.repairelectricbike.model.RepairOrder;
import se.kth.iv1350.repairelectricbike.model.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.model.dto.RepairOrderDTO;

import java.util.List;
/**
 * Handles all system operations and coordinates communication between the view, model and integration layers.
 */
public class Controller {

    private RepairOrder currentRepairOrder;
        
    private final CustomerRegistry customerRegistry;
    private final RepairOrderRegistry repairOrderRegistry;
    private final Printer printer;
    
    private int nextOrderId = 1; 
    /**
     * Creates a new controller instance and initializes the required registries.
     *
     * @param registryCreator Provides access to the customer and repair order registries.
     * @param printer Handles printing of repair order information.
     */
    public Controller(RegistryCreator registryCreator, Printer printer){
        this.customerRegistry = registryCreator.getCustomerRegistry(); 
        this.repairOrderRegistry = registryCreator.getRepairOrderRegistry(); //getRepairOrderRegistry behöver läggas till  i RegistryCreator.java
        this.printer = printer;
    }

    /**
     * Searches for a customer in the customer registry using their phone number.
     * @param phoneNumber The phone number of the customer to find.
     * @return CustomerDTO with customer information, or null if customer is not found
     */
    public CustomerDTO findCustomer(String phoneNumber) {
        return customerRegistry.findCustomer(phoneNumber);
    }

    /**
     * Creates a new repair order and saves it to registry.
     * @param problemDescr A description of the problem reported by the customer.
     * @param phoneNumber The phone number of the customer.
     * @param serialNo The serial number of the bike to be repaired.
     */
    public void createRepairOrder(String problemDescr, String phoneNumber, int serialNo){
        currentRepairOrder = new RepairOrder(nextOrderId++, problemDescr);
        repairOrderRegistry.createRepairOrder(currentRepairOrder);
    }

    /**
     * Returns all currently stored repair orders
     * @return List of RepairOrderDTO representing all repair orders in the registry
     */
    public List<RepairOrderDTO> findAllRepairOrders(){
        return repairOrderRegistry.findAllRepairOrders();
    }

    /**
     * Accepts a repair order by changing its state to "ACCEPTED" and updates it in the registry.
     * @param id The ID of the repair order to accept.
     */
    public void acceptRepairOrder(int id){
        if(currentRepairOrder != null && currentRepairOrder.getId() == id){
            currentRepairOrder.setState("ACCEPTED"); //ev. enum State.ACCEPTED
            repairOrderRegistry.updateRepairOrder(currentRepairOrder);
            printer.printRepairOrder(currentRepairOrder.toString());
        }
    }

    /**
     * Rejects a repair order by changing its state to "REJECTED" and updates it in the registry.
     * @param id The ID of the repair order to reject
     */
    public void rejectRepairOrder(int id){
        if(currentRepairOrder != null && currentRepairOrder.getId() == id){
            currentRepairOrder.setState("REJECTED"); //ev. enum State.REJECTED
            repairOrderRegistry.updateRepairOrder(currentRepairOrder);
        }
    }

    /**
     * Adds a diagnostic result to the current repair order and updates it in the registry.
     * @param id The ID of the repair order to update.
     * @param result The diagnostic result to add.
     */
    public void addDiagnosticResult(int id, String result){
        if(currentRepairOrder != null && currentRepairOrder.getId() == id){
            currentRepairOrder.addDiagnosticResult(id, result);
            repairOrderRegistry.updateRepairOrder(currentRepairOrder);
        }
    }

    /**
     * Adds a repair task to the current repair order and updates it in the registry.
     * @param id The ID of the repair order to update.
     * @param task A description of the repair task to add.
     */
    public void addRepairTask(int id, String task){
        if(currentRepairOrder != null && currentRepairOrder.getId() == id){
            currentRepairOrder.addRepairTask(task);
            repairOrderRegistry.updateRepairOrder(currentRepairOrder);
        }
    }


}

