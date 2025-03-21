//Main class
public class EcommerceSystem {
    public static void main(String[] args) {
        // Create a list of products
        Product[] products = {
                new Electronics(101, "Gaming-Laptop", 50000, 0.10),
                new Clothing(102, "Mobile", 25000, 0.15),
                new Groceries(103, "Camera", 80000, 0.05)
        };

        // Print final price for each product
        for (Product product : products) {
            double discount = product.calculateDiscount();
            double tax = 0;
            String taxDetails = "No tax applicable";

            if (product instanceof Taxable) {
                Taxable taxableProduct = (Taxable) product;
                tax = taxableProduct.calculateTax();
                taxDetails = taxableProduct.getTaxDetails();
            }

            double finalPrice = product.getPrice() + tax - discount;
            System.out.println("Product: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Discount: -" + discount);
            System.out.println(taxDetails);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("-".repeat(40));
        }
    }
}
// Abstract Product class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getter and setter methods (Encapsulation)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method for calculating discount
    public abstract double calculateDiscount();
}

// Electronics subclass
class Electronics extends Product implements Taxable {
    private double discountRate;

    public Electronics(int productId, String name, double price, double discountRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }

    @Override
    public double calculateTax() {
        // Assume 15% tax rate for Electronics
        return getPrice() * 0.15;
    }

    @Override
    public String getTaxDetails() {
        return "Tax for Electronics: 15% of " + getPrice() + " = " + calculateTax();
    }
}

// Clothing subclass
class Clothing extends Product implements Taxable {
    private double discountRate;

    public Clothing(int productId, String name, double price, double discountRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }

    @Override
    public double calculateTax() {
        // Assume 10% tax rate for Clothing
        return getPrice() * 0.10;
    }

    @Override
    public String getTaxDetails() {
        return "Tax for Clothing: 10% of " + getPrice() + " = " + calculateTax();
    }
}

// Groceries subclass
class Groceries extends Product {
    private double discountRate;

    public Groceries(int productId, String name, double price, double discountRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }
}

// Taxable interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}
//output
// Product: Gaming-Laptop
//Price: 50000.0
//Discount: -5000.0
//Tax for Electronics: 15% of 50000.0 = 7500.0
//Final Price: 52500.0
//----------------------------------------
//Product: Mobile
//Price: 25000.0
//Discount: -3750.0
//Tax for Clothing: 10% of 25000.0 = 2500.0
//Final Price: 23750.0
//----------------------------------------
//Product: Camera
//Price: 80000.0
//Discount: -4000.0
//No tax applicable
//Final Price: 76000.0
//----------------------------------------