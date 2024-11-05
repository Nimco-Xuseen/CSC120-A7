import java.util.Hashtable;

public class Library extends Building {

    /* List of all the books in the library's collection */
    private Hashtable<String, Boolean> collection;
    /* List of all the users who checked out books and the title of each book */
    private Hashtable<String, String> checkoutInfo;

    /**
     * Creates a new library.
     * @param name String
     * @param address String
     * @param nFloors int
     */
    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.collection = new Hashtable<>();
        this.checkoutInfo = new Hashtable<>();
        System.out.println("You have built a library: 📖");
    }

    /**
     * Creates a new default library.
     */
    public Library() {
        this("Unknown", "Unknown", 1);
    }

    /**
     * Adds a new book to the library's collection.
     * @param title String
     */
    public void addTitle(String title) {
        if (this.collection.containsKey(title)) {
            throw new RuntimeException("This book is already a part of the collection.");
        }
        this.collection.put(title, true);
        System.out.println("This book has been added to the collection.");
    }

    /**
     * Removes a book from the library's collection.
     * @param title String
     * @return name of the book removed
     */
    public String removeTitle(String title) {
        if (!this.collection.containsKey(title)) {
            throw new RuntimeException("This book is not a part of the collection.");
        }
        this.collection.remove(title);
        System.out.println("This book has been removed from the collection.");
        return title;
    }

    /**
     * Checks out a book from the collection.
     * @param title String
     * @param requesterName String (optional)
     */
    public void checkOut(String title, String requesterName) {
        if (!this.collection.containsKey(title)) {
            throw new RuntimeException("This book is not a part of the collection.");
        }
        if (!this.collection.get(title)) {
            throw new RuntimeException("This book is already checked out.");
        }
        this.collection.replace(title, false);
        this.checkoutInfo.put(title, requesterName);
        System.out.println("This book has been successfully checked out by " + requesterName);
    }

    /**
     * Returns a book to the collection.
     * @param title String
     */
    public void returnBook(String title) {
        if (!this.collection.containsKey(title)) {
            throw new RuntimeException("This book is not a part of the collection.");
        }
        this.collection.replace(title, true);
        this.checkoutInfo.remove(title);
        System.out.println("This book has been successfully returned.");
    }

    /**
     * Checks if the collection contains a certain book.
     * @param title String
     * @return true if it contains the book or false if it doesn't.
     */
    public boolean containsTitle(String title) {
        return this.collection.containsKey(title);
    }

    /**
     * Indicates whether or not a book is available to check out.
     * @param title String
     * @return true if it is available or false if it isn't.
     */
    public boolean isAvailable(String title) {
        if (!this.collection.containsKey(title)) {
            throw new RuntimeException("This book is not a part of the collection.");
        }
        return this.collection.get(title);
    }

    /**
     * Prints a list of the entire collection
     */
    public void printCollection() {
        for (String key : this.collection.keySet()) {
            System.out.println("Title: " + key + ", Checkout Status: " + (this.collection.get(key) ? "Available" : "Checked Out"));
        }
    }

    /**
     * Prints all the available options
     */
    public void showOptions() {
        super.showOptions();
    }

    /**
     * Allows user to move between floors
     */
    public void goToFloor(int floorNum) {
        super.goToFloor(floorNum);
    }

    public static void main(String[] args) {
        new Library();
    }
}

