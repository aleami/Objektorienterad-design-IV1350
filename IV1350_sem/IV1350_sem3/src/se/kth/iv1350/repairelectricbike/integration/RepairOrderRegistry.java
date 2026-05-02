package se.kth.iv1350.repairelectricbike.integration;

import se.kth.iv1350.repairelectricbike.model.RepairOrder;
import se.kth.iv1350.repairelectricbike.model.dto.RepairOrderDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores repair orders in the system.
 */
public class RepairOrderRegistry {

    private List<RepairOrder> repairOrders = new ArrayList<>();

    /**
     * Creates a repair order registry.
     */
    public RepairOrderRegistry() {
    }

    /**
     * Adds a new repair order.
     *
     * @param repairOrder The repair order to add.
     */
    public void createRepairOrder(RepairOrder repairOrder) {
        repairOrders.add(repairOrder);
    }

    /**
     * Updates an existing repair order.
     *
     * @param repairOrder The repair order to update.
     */
    public void updateRepairOrder(RepairOrder repairOrder) {
        for (int i = 0; i < repairOrders.size(); i++) {
            if (repairOrders.get(i).getId() == repairOrder.getId()) {
                repairOrders.set(i, repairOrder);
                return;
            }
        }
    }

    /**
     * Finds a repair order by ID.
     *
     * @param id The repair order ID.
     * @return The repair order, or null if not found.
     */
    public RepairOrder findRepairOrder(int id){
        for(RepairOrder order : repairOrders){
            if(order.getId() == id){
                return order;
            }
        }
        return null;
    }

    /**
     * Returns all repair orders as DTOs.
     * @return List of RepairOrderDTOs
     */
    public List<RepairOrderDTO> findAllRepairOrders() {
        List<RepairOrderDTO> result = new ArrayList<>();

        for (RepairOrder order : repairOrders) {
            result.add(new RepairOrderDTO(
                    order.getId(),
                    order.getDate(),
                    order.getProblemDesc(),
                    order.getState()
            ));
        }
        return result;
    }
}