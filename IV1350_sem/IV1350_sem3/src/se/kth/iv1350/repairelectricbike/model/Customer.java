package se.kth.iv1350.repairelectricbike.model;

public class Customer {
    private  String name;
    private  String email;
    private  String phoneNumber;
    private  String bikeBrand;
    private  String bikeSerialNo;
    private  String bikeModel;
/**
 * Creates a new Customer.
 *
 * @param name The customer's name.
 * @param email The customer's email.
 * @param bikeBrand The bike's brand.
 * @param bikeSerialNo The bike's serial number.
 * @param bikeModel The bike's model.
 */
    public Customer(String name, String email, String phoneNumber, String bikeBrand, String bikeSerialNo, String bikeModel) {
        this.name = name;
        this.email = email;
        this.bikeBrand = bikeBrand;
        this.bikeSerialNo = bikeSerialNo;
        this.bikeModel = bikeModel;
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return The customer's name.
     */
    public String getName() {
        return name;
    }  
     
    /**
     * @return The customer's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return The customer's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return The bike brand.
     */
    public String getBikeBrand() {
        return bikeBrand;
    }

    /**
     * @return The bike serial number.
     */
    public String getBikeSerialNo() {
        return bikeSerialNo;
    }

    /**
     * @return The bike model.
     */
    public String getBikeModel() {
        return bikeModel;
    }



}