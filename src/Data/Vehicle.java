package Data;

import java.time.LocalDate;

public abstract class Vehicle {
    private int vehicleId; // Unique identifier for the vehicle
    private String vehicleModel; // Model of the vehicle
    private String registrationNumber; // Registration number
    private String manufacturerName; // Name of the manufacturer
    private LocalDate registrationDate; // Date of registration
    private String locationBase; // Base location of the vehicle
    private String vehicleCategory; // Category/type of the vehicle

    // Constructor
    public Vehicle(int vehicleId, String vehicleModel, String registrationNumber, String manufacturerName, LocalDate registrationDate, String locationBase) {
        this.vehicleId = vehicleId;
        this.vehicleModel = vehicleModel;
        this.registrationNumber = registrationNumber;
        this.manufacturerName = manufacturerName;
        this.registrationDate = registrationDate;
        this.locationBase = locationBase;
    }

    // Abstract method to calculate rental cost, implemented differently for each type
    public abstract double calculateRate(int hours, int km);


    // Override toString to display vehicle details
    @Override
    public String toString() {
        return "Vehicle ID: " + vehicleId +
                "\nCategory: " + vehicleCategory +
                "\nRegistration Number: " + registrationNumber +
                " (Registered on: " + registrationDate + ")" +
                "\nModel: " + vehicleModel +
                "\nManufacturer: " + manufacturerName +
                "\nLocation: " + locationBase;
    }

    // Getter for vehicle ID
    public int getVehicleId() {
        return vehicleId;
    }

    // Getter for vehicle category (can be overridden by subclasses)
    public String getVehicleCategory() {
        return vehicleCategory;
    }
}
