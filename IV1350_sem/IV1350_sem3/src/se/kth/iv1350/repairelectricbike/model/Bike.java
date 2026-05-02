package se.kth.iv1350.repairelectricbike.model;

/**
 * Represents a bike.
 */
public class Bike {

    private String brand;
    private String model;
    private String serialNumber;

    /**
     * Creates a bike.
     */
    public Bike(String brand, String model, String serialNumber) {
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
    }

    /**
     * @return bike brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @return bike model
     */
    public String getModel() {
        return model;
    }

    /**
     * @return serial number
     */
    public String getSerialNumber() {
        return serialNumber;
    }
}