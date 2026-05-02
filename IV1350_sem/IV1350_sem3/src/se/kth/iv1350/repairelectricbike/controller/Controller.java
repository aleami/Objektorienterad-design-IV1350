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
//Vad som behöver fixas:RegistryCreator.java, behvöer skrivas om (se kod) och
//RepairOrderRegistry.java, behöver också skrivas om, den anropar RepairOrderDTO med fel argument; behöver en getDate(),
//RepairOrder.java saknar också getDate().

//Har också kommentarer att skriva till för @params och @returns
public class Controller {

    //Håller koll på den nuvarande reparationsordern som är aktiv
    private RepairOrder currentRepairOrder;
        
    private final CustomerRegistry customerRegistry;
    private final RepairOrderRegistry repairOrderRegistry;
    private final Printer printer;
    
    private int nextOrderId = 1; //Räknare för att ge reparationdorder unikt ID
    /**
     * Creates a new controller.
     * @param registryCreator
     * @param printer
     */
    public Controller(RegistryCreator registryCreator, Printer printer){
        this.customerRegistry = registryCreator.getCustomerRegistry(); //getCustomerRegistry behöver läggas till  i RegistryCreator.java
        this.repairOrderRegistry = registryCreator.getRepairOrderRegistry(); //getRepairOrderRegistry behöver läggas till  i RegistryCreator.java
        this.printer = printer;
    }

    /**
     * Searches for a customer in the customer registry using their phone number.
     * @param phoneNumber
     * @return CustomerDTO with customer information, or null if customer is not found
     */
    public CustomerDTO findCustomer(String phoneNumber) {
        return customerRegistry.findCustomer(phoneNumber);
    }

    /**
     * Creates a new repair order and saves it to registry.
     * @param problemDescr
     * @param phoneNumber
     * @param serialNo
     */
    public void createRepairOrder(String problemDescr, String phoneNumber, int serialNo){
        currentRepairOrder = new RepairOrder(nextOrderId++, problemDescr);
        repairOrderRegistry.createRepairOrder(currentRepairOrder);
    }

    /**
     * Returns all stored repair orders
     * @return List of RepairOrderDTO representing all repair orders in the registry
     */
    public List<RepairOrderDTO> findAllRepairOrders(){
        return repairOrderRegistry.findAllRepairOrders();
    }

    /**
     * Accepts a repair order by changing its state to "ACCEPTED" and updates it in the registry.
     * @param id
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
     * @param id
     */
    public void rejectRepairOrder(int id){
        if(currentRepairOrder != null && currentRepairOrder.getId() == id){
            currentRepairOrder.setState("REJECTED"); //ev. enum State.REJECTED
            repairOrderRegistry.updateRepairOrder(currentRepairOrder);
        }
    }

    /**
     * Adds a diagnostic result to the current repair order and updates it in the registry.
     * @param id
     * @param result
     */
    public void addDiagnosticResult(int id, String result){
        if(currentRepairOrder != null && currentRepairOrder.getId() == id){
            currentRepairOrder.addDiagnosticResult(id, result);
            repairOrderRegistry.updateRepairOrder(currentRepairOrder);
        }
    }

    /**
     * Adds a repair task to the current repair order and updates it in the registry.
     * @param id
     * @param task
     */
    public void addRepairTask(int id, String task){
        if(currentRepairOrder != null && currentRepairOrder.getId() == id){
            currentRepairOrder.addRepairTask(task);
            repairOrderRegistry.updateRepairOrder(currentRepairOrder);
        }
    }


}

