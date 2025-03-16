// Main class
public class VehicleSystem {
    public static void main(String[] args) {
        // Create a list of vehicles
        Vehicle[] vehicles = {
                new Car("car1241", "Car", 80, "C1233114"),
                new Bike("bike1412", "Bike", 60, "B678323190"),
                new Truck("Trk14414", "Truck", 110, "T111413411")
        };

        // Number of rental days for the vehicles
        int rentalDays = 5;

        // Iterate over the list of vehicles and calculate rental and insurance costs
        for (Vehicle vehicle : vehicles) {
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            double insuranceCost = 0;
            String insuranceDetails = "No insurance available";

            // If the vehicle is insurable, calculate insurance
            if (vehicle instanceof Insurable) {
                Insurable insurableVehicle = (Insurable) vehicle;
                insuranceCost = insurableVehicle.calculateInsurance();
                insuranceDetails = insurableVehicle.getInsuranceDetails();
            }

            // Display rental and insurance details
            System.out.println("Vehicle: " + vehicle.getType());
            System.out.println("Rental Cost for " + rentalDays + " days: " + rentalCost);
            System.out.println("Insurance Cost: " + insuranceCost);
            System.out.println(insuranceDetails);
            System.out.println("-".repeat(40));
        }
    }
}

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Getter and setter methods (Encapsulation)
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    // Abstract method to calculate rental cost
    public abstract double calculateRentalCost(int days);
}

// Car subclass
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, type, rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        // Calculate rental cost for car (simple rate * days)
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        // Assume insurance cost for Car is 10% of the rental cost
        return calculateRentalCost(1) * 0.10; // for 1 day rental
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy Number: " + insurancePolicyNumber;
    }
}

// Bike subclass
class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, type, rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        // Calculate rental cost for bike (simple rate * days)
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        // Assume insurance cost for Bike is 5% of the rental cost
        return calculateRentalCost(1) * 0.05; // for 1 day rental
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy Number: " + insurancePolicyNumber;
    }
}

// Truck subclass
class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, type, rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        // Calculate rental cost for truck (simple rate * days)
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        // Assume insurance cost for Truck is 15% of the rental cost
        return calculateRentalCost(1) * 0.15; // for 1 day rental
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy Number: " + insurancePolicyNumber;
    }
}

// Insurable interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}
//output
// Vehicle: Car
//Rental Cost for 5 days: 400.0
//Insurance Cost: 8.0
//Insurance Policy Number: C1233114
//----------------------------------------
//Vehicle: Bike
//Rental Cost for 5 days: 300.0
//Insurance Cost: 3.0
//Insurance Policy Number: B678323190
//----------------------------------------
//Vehicle: Truck
//Rental Cost for 5 days: 550.0
//Insurance Cost: 16.5
//Insurance Policy Number: T111413411
//----------------------------------------