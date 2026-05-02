package se.kth.iv1350.repairelectricbike.integration;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.repairelectricbike.model.dto.CustomerDTO;

/**
 * Unit tests for the CustomerRegistry class.
 */
public class CustomerRegistryTest {
    private CustomerRegistry customerRegistry;

    @BeforeEach
    public void setUp() {
        customerRegistry = new CustomerRegistry();
    }

    @Test
    public void testFindCustomerReturnsOscarForExistingPhone() {
        CustomerDTO customer = customerRegistry.findCustomer("01234");

        assertCustomer(customer, "Oscar", "oscar@kth.com", "01234",
                "Cannondale", "SN345678", "Superior Pro");
    }

    @Test
    public void testFindCustomerReturnsAleenaForExistingPhone() {
        CustomerDTO customer = customerRegistry.findCustomer("05678");

        assertCustomer(customer, "Aleena", "aleena@kth.com", "05678",
                "Specialized", "SN987654", "Turbo Vado");
    }

    @Test
    public void testFindCustomerReturnsEmiliaForExistingPhone() {
        CustomerDTO customer = customerRegistry.findCustomer("091011");

        assertCustomer(customer, "Emilia", "emilia@kth.com", "091011",
                "Trek", "SN234567", "Fuel EX");
    }

    @Test
    public void testFindCustomerReturnsNullForUnknownPhone() {
        CustomerDTO customer = customerRegistry.findCustomer("000000");

        assertNull(customer,
                "findCustomer should return null when the phone number is not registered.");
    }

    private void assertCustomer(CustomerDTO customer, String name, String email,
            String phone, String bikeBrand, String bikeSerialNo, String bikeModel) {
        assertNotNull(customer, "Customer should not be null.");
        assertAll(
                () -> assertEquals(name, customer.getName(), "Name should match."),
                () -> assertEquals(email, customer.getEmail(), "Email should match."),
                () -> assertEquals(phone, customer.getPhoneNumber(), "Phone should match."),
                () -> assertEquals(bikeBrand, customer.getBikeBrand(), "Bike brand should match."),
                () -> assertEquals(bikeSerialNo, customer.getBikeSerialNo(), "Serial number should match."),
                () -> assertEquals(bikeModel, customer.getBikeModel(), "Bike model should match."));
    }
}
