package Data;

import java.time.LocalDate;
import java.util.Arrays;

// Petrol class is an abstract class that extends Vehicle class
public abstract class Petrol extends Vehicle {
    private double engine; // Engine size in liters
    private int co2;       // CO2 emissions in g/km

    // Constructor to initialize Petrol attributes
    public Petrol(int id, String model, String regNo, String manufacturer, LocalDate regDate, String[] location, double engine, int co2) {
        super(id, model, regNo, manufacturer, regDate, Arrays.toString(location));
        this.engine = engine;
        this.co2 = co2;
    }

    // Getters for engine and CO2 emissions
    public double getEngine() {
        return engine;
    }

    public int getCo2() {
        return co2;
    }

    // Setters for engine and CO2 emissions
    public void setEngine(double engine) {
        this.engine = engine;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEngine Size: " + engine + " liters" +
                "\nCO2 Emissions: " + co2 + " g/km";
    }
}
