import java.util.ArrayList;

public class House extends Building {
    private ArrayList<String> residents; // List of all the residents in the house
    private boolean hasDiningRoom; // Whether or not the house has a dining room
    private boolean hasElevator; // Whether or not the house has an elevator

    // Default constructor
    public House() {
        super("Unknown", "Unknown", 1);
        this.hasDiningRoom = false;
        this.hasElevator = false;
        this.residents = new ArrayList<>();
        System.out.println("You have built a house: 🏠");
    }

    // Constructor with name, address, and floors
    public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
        super(name, address, nFloors);
        this.hasDiningRoom = hasDiningRoom;
        this.hasElevator = hasElevator;
        this.residents = new ArrayList<>();
        System.out.println("You have built a house: 🏠");
    }

    // Constructor with dining room and elevator
    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        this(name, address, nFloors, hasDiningRoom, true); // Default hasElevator to true
    }

    // Constructor with 2 floors
    public House(String name, String address, boolean hasDiningRoom, boolean hasElevator) {
        this(name, address, 2, hasDiningRoom, hasElevator); // Default floors to 2
    }

    public boolean hasDiningRoom() {
        return this.hasDiningRoom;
    }

    public boolean hasElevator() {
        return this.hasElevator;
    }

    public int nResidents() {
        return this.residents.size();
    }

    public void moveIn(String name) {
        if (this.residents.contains(name)) {
            throw new RuntimeException(name + " is already a resident of this house.");
        }
        this.residents.add(name);
        System.out.println(name + " is now a resident of this house.");
    }

    public String moveOut(String name) {
        if (!this.residents.contains(name)) {
            throw new RuntimeException(name + " is not a resident of this house.");
        }
        this.residents.remove(name);
        System.out.println(name + " is no longer a resident of this house.");
        return name;
    }

    public boolean isResident(String person) {
        return this.residents.contains(person);
    }

    public void showOptions() {
        if (this.hasElevator) {
            super.showOptions();
        } else {
            System.out.println("Available options at " + getName() + ":\n + enter() \n + exit() \n + goUp() \n + goDown()");
        }
    }

    public void goToFloor(int floorNum) {
        if (!this.hasElevator) {
            throw new RuntimeException("This house does not have an elevator.");
        }
        super.goToFloor(floorNum);
    }

    public static void main(String[] args) {
        new House();
    }
}
