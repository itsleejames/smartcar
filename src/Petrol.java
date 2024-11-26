import java.time.LocalDate;

public abstract class Petrol extends Vehicle {
    protected double engine; // Engine size in liters
    protected int co2; // CO2 emissions in g/km

    // Constructor
    public Petrol(int id, String regNo, String manufacturer, String model, LocalDate regDate, String location, double engine, int co2) {
        super(id, regNo, manufacturer, model, regDate, location);
        this.engine = engine;
        this.co2 = co2;
    }

    // Getters
    public double getEngine() {
        return engine;
    }

    public int getCo2() {
        return co2;
    }

    // Setters
    public void setEngine(double engine) {
        this.engine = engine;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    // Abstract method for calculating the rental rate (to be implemented by subclasses)
    @Override
    public abstract double calculateRate(int duration, double distance);

    // Method to display petrol vehicle details
    public String displayPetrolDetails() {
        return "Engine: " + engine + "L\n" +
                "CO2 Emissions: " + co2 + " g/km";
    }
}
