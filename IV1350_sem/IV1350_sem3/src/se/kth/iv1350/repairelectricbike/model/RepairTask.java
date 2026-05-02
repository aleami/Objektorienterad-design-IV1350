package se.kth.iv1350.repairelectricbike.model;

/**
 * Represents a repair task that is performed on a repair order.
 */
public class RepairTask {

    private String name;
    private String description;
    private double cost;
    private String state;

    /**
     * Creates a new repair task.
     *
     * @param name The name of the task.
     * @param description the description of the task.
     * @param cost The cost for the repair task.
     * @param state The current state of the task.
     */

    public RepairTask(String name, String description, double cost, String state) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.state = state;
    }

    /**
     * @return The name of the task.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return The cost of the task.
     */
    public double getCost() {
        return cost;
    }

    /**
     * @return The current state of the task.
     */
    public String getState() {
        return state;
    }

    /**
     * Updates the state of the task.
     *
     * @param state The new state.
     */
    public void setState(String state) {
        this.state = state;
    }
}