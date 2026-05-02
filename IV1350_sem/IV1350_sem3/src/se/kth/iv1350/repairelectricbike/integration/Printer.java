package se.kth.iv1350.repairelectricbike.integration;

/**
 * Handles the output of repair order information to the user.
*/

public class Printer {

/**
* Creates a new Printer.
*/
    public Printer() {
    }
/**
 * Prints repair order information.
*
* @param order The information containing repair order to print.
*/
    public void printRepairOrder(String order) {
        System.out.println(order);
    }
}