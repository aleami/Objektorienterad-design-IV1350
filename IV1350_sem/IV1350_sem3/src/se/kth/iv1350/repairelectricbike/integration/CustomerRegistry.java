package se.kth.iv1350.repairelectricbike.integration;
import java.util.ArrayList;
import se.kth.iv1350.repairelectricbike.model.Customer;
import se.kth.iv1350.repairelectricbike.model.dto.CustomerDTO;

/**
 * Stores customer data.
*/
public class CustomerRegistry {
    private ArrayList<Customer> customers;

/**
* Creates a customer registry with some example customers.
*/
    public CustomerRegistry(){
        customers = new ArrayList<>();
        customers.add(new Customer("Oscar", "oscar@kth.com", "01234", "Cannondale", "SN345678", "Superior Pro"));
        customers.add(new Customer("Aleena", "aleena@kth.com", "05678", "Specialized", "SN987654", "Turbo Vado"));
        customers.add(new Customer("Emilia", "emilia@kth.com", "091011", "Trek", "SN234567", "Fuel EX"));
    }

    /**
     * Finds a customer by phone number.
     *
     * @param phoneNumber The customer's phone number.
     * @return A CustomerDTO if found, otherwise null.
     */
    public CustomerDTO findCustomer(String phoneNumber){
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                
                return new CustomerDTO(customer.getName(), customer.getEmail(), customer.getPhoneNumber(), customer.getBikeBrand(), customer.getBikeSerialNo(), customer.getBikeModel());
            }
        }
        return null; 
    }
    
}
