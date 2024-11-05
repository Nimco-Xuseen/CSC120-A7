import java.util.Hashtable;

public class Cafe extends Building {
    private int nCoffeeOunces; // Number of coffee ounces in stock
    private int nSugarPackets; // Number of sugar packets in stock
    private int nCreams; // Number of creams in stock
    private int nCups; // Number of cups in stock
    private Hashtable<Integer, String> employees; // Hashtable to store employees

    /**
     * Creates a new cafe.
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.employees = new Hashtable<>();
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Creates a new default cafe.
     */
    public Cafe() {
        this("Unknown", "Unknown", 1, 0, 0, 0, 0);
    }

    /**
     * Creates a new cafe without a set stock of ingredients.
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 0;
        this.nSugarPackets = 0;
        this.nCreams = 0;
        this.nCups = 0;
        this.employees = new Hashtable<>();
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Sells coffee and adjusts stock based on the order.
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (nCups < 1 || nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || nCreams < this.nCreams) {
            restock(size, nSugarPackets, nCreams, 1);
            sellCoffee(size, nSugarPackets, nCreams); // Re-attempt after restock
            return;
        }
        // Process the order
        nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets; // Use the field correctly
        nCreams -= nCreams;
        nCups--;
        System.out.println("Order successful.");
    }
    

    public void sellCoffee(int size, int nSugarPackets) {
        sellCoffee(size, nSugarPackets, 2);
    }

    public void sellCoffee(int size) {
        sellCoffee(size, 0, 0);
    }

    /**
     * Restocks the ingredients in the cafe.
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("The ingredients have been restocked.");
    }

    /**
     * Shows the available options.
     */
    public void showOptions() {
        super.showOptions();
    }

    /**
     * Allows user to move to another floor only if they are an employee.
     */
    public void goToFloor(int floorNum, Integer employeeID) {
        if (!employees.containsKey(employeeID)) {
            throw new RuntimeException(employeeID + " is not a valid employee ID.");
        }
        super.goToFloor(floorNum);
    }

    public static void main(String[] args) {
        new Cafe();
    }
}
