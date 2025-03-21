//Main class
public class LibrarySystem {
    public static void main(String[] args) {
        // Create different types of library items
        LibraryItem[] items = {
                new Book("B1344", "C++ tutorials", "joe"),
                new Magazine("M41326", "Tech Trends", "Jaden"),
                new DVD("D723789", "The Matrix", "aizen")
        };

        // Process each item
        for (LibraryItem item : items) {
            // Get item details
            System.out.println(item.getItemDetails());
            // Get loan duration
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            // Demonstrate polymorphism with Reservable items
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                if (reservableItem.checkAvailability()) {
                    reservableItem.reserveItem();
                } else {
                    System.out.println("Item is not available.");
                }
            }
            System.out.println("-".repeat(40)); // Print separator
        }
    }
}

// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    // Constructor
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Getter and setter methods (Encapsulation)
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Concrete method to get general item details
    public String getItemDetails() {
        return "Item ID: " + itemId + "\nTitle: " + title + "\nAuthor: " + author;
    }

    // Abstract method to get loan duration
    public abstract int getLoanDuration();
}

// Book subclass
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        // Books can be loaned for 14 days
        return 14;
    }

    @Override
    public void reserveItem() {
        System.out.println("Book \"" + getTitle() + "\" reserved.");
    }

    @Override
    public boolean checkAvailability() {
        // Assume all books are available (for simplicity)
        return true;
    }
}

// Magazine subclass
class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        // Magazines can be loaned for 7 days
        return 7;
    }

    @Override
    public void reserveItem() {
        System.out.println("Magazine \"" + getTitle() + "\" reserved.");
    }

    @Override
    public boolean checkAvailability() {
        // Assume all magazines are available (for simplicity)
        return true;
    }
}

// DVD subclass
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        // DVDs can be loaned for 3 days
        return 3;
    }

    @Override
    public void reserveItem() {
        System.out.println("DVD \"" + getTitle() + "\" reserved.");
    }

    @Override
    public boolean checkAvailability() {
        // Assume all DVDs are available (for simplicity)
        return true;
    }
}

// Reservable interface
interface Reservable {
    void reserveItem(); // Method to reserve the item
    boolean checkAvailability(); // Method to check if the item is available
}

//output
// Item ID: B1344
//Title: C++ tutorials
//Author: joe
//Loan Duration: 14 days
//Book "C++ tutorials" reserved.
//----------------------------------------
//Item ID: M41326
//Title: Tech Trends
//Author: Jaden
//Loan Duration: 7 days
//Magazine "Tech Trends" reserved.
//----------------------------------------
//Item ID: D723789
//Title: The Matrix
//Author: aizen
//Loan Duration: 3 days
//DVD "The Matrix" reserved.
//----------------------------------------