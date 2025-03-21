// Main Class
public class OnlineFoodSystem {
    public static void main(String[] args) {
        // Create different food items
        FoodItem[] foodItems = {
                new VegItem("Chicken Pizza", 8.99, 2),
                new NonVegItem("Chicken Burger", 5.99, 3),
                new VegItem("Pastries", 6.50, 1)
        };

        // Process each food item
        for (FoodItem foodItem : foodItems) {
            // Display food item details
            System.out.println(foodItem.getItemDetails());

            // Calculate and display the total price for the item
            System.out.println("Total Price (before discount): $" + foodItem.calculateTotalPrice());

            // Demonstrating polymorphism with Discountable items
            if (foodItem instanceof Discountable) {
                Discountable discountableItem = (Discountable) foodItem;
                System.out.println(discountableItem.getDiscountDetails());
                discountableItem.applyDiscount();
            }
            System.out.println("-".repeat(40)); // Print separator
        }
    }
}
// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter and setter methods (Encapsulation)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Concrete method to get item details
    public String getItemDetails() {
        return "Item Name: " + itemName + "\nPrice: $" + price + "\nQuantity: " + quantity;
    }

    // Abstract method to calculate total price
    public abstract double calculateTotalPrice();
}

// VegItem subclass
class VegItem extends FoodItem implements Discountable {
    private static final double DISCOUNT_RATE = 0.05; // 5% discount for veg items

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity(); // No extra charge for veg items
    }

    @Override
    public void applyDiscount() {
        double discountAmount = calculateTotalPrice() * DISCOUNT_RATE;
        double finalPrice = calculateTotalPrice() - discountAmount;
        System.out.println("Discount applied: $" + discountAmount);
        System.out.println("Final Price (after discount): $" + finalPrice);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount on Veg Item: " + DISCOUNT_RATE * 100 + "% off";
    }
}

// NonVegItem subclass
class NonVegItem extends FoodItem implements Discountable {
    private static final double NON_VEG_EXTRA_CHARGE = 2.0; // Additional charge for non-veg items
    private static final double DISCOUNT_RATE = 0.02; // 2% discount for non-veg items

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        // Additional charge for non-veg items
        return (getPrice() + NON_VEG_EXTRA_CHARGE) * getQuantity();
    }

    @Override
    public void applyDiscount() {
        double discountAmount = calculateTotalPrice() * DISCOUNT_RATE;
        double finalPrice = calculateTotalPrice() - discountAmount;
        System.out.println("Discount applied: $" + discountAmount);
        System.out.println("Final Price (after discount): $" + finalPrice);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount on Non-Veg Item: " + DISCOUNT_RATE * 100 + "% off";
    }
}

// Discountable interface
interface Discountable {
    void applyDiscount(); // Method to apply discount
    String getDiscountDetails(); // Method to get discount details
}

//output
// Item Name: Chicken Pizza
//Price: $8.99
//Quantity: 2
//Total Price (before discount): $17.98
//Discount on Veg Item: 5.0% off
//Discount applied: $0.899
//Final Price (after discount): $17.081
//----------------------------------------
//Item Name: Chicken Burger
//Price: $5.99
//Quantity: 3
//Total Price (before discount): $23.97
//Discount on Non-Veg Item: 2.0% off
//Discount applied: $0.4794
//Final Price (after discount): $23.4906
//----------------------------------------
//Item Name: Pastries
//Price: $6.5
//Quantity: 1
//Total Price (before discount): $6.5
//Discount on Veg Item: 5.0% off
//Discount applied: $0.325
//Final Price (after discount): $6.175
//----------------------------------------
