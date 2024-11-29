package Data;

import java.time.LocalDate;

// SmartElectric class extends Vehicle, representing an electric-powered vehicle
public class SmartElectric extends Vehicle {
    private static final double HOURLY_RATE = 14.0; // Hourly rate in euros
    private static final double DAILY_RATE = 70.0;  // Daily rate in euros

    private double batteryCapacity; // Battery capacity in kWh
    private int range;              // Range of the vehicle in kilometers
    private int efficiency;         // Efficiency in Wh/km

    // Constructor to initialize SmartElectric attributes
    public SmartElectric(int id, String model, String regNo, String manufacturer, LocalDate regDate, String location, double batteryCapacity, int range, int efficiency) {
        super(id, model, regNo, manufacturer, regDate, location);
        this.batteryCapacity = batteryCapacity;
        this.range = range;
        this.efficiency = efficiency;
    }

    // Overriding the calculateRate method from Vehicle class
    @Override
    public double calculateRate(int hours, int km) {
        // Calculate base rate based on hours or daily rate
        double baseRate = (hours <= 24) ? hours * HOURLY_RATE : DAILY_RATE;

        // No additional charge for kilometers driven as electric vehicles are eco-friendly
        return baseRate;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nBattery Capacity: " + batteryCapacity + " kWh" +
                "\nRange: " + range + " km" +
                "\nEfficiency: " + efficiency + " Wh/km" +
                "\nHourly Rate: €" + HOURLY_RATE +
                "\nDaily Rate: €" + DAILY_RATE;
    }
}
