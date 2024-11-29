package Data;

import java.time.LocalDate;

// SmartCity class extends Petrol, representing a petrol-powered city car
public class SmartCity extends Petrol {
    private static final double HOURLY_RATE = 11.0; // Hourly rate in euros
    private static final double DAILY_RATE = 55.0;  // Daily rate in euros

    // Constructor to initialize SmartCity attributes
    public SmartCity(int id, String model, String regNo, String manufacturer, LocalDate regDate, String[] location, double engine, int co2) {
        super(id, model, regNo, manufacturer, regDate, location, engine, co2);
    }

    // Overriding the calculateRate method from Vehicle class
    @Override

    public double calculateRate(int hours, int km) {
        // Calculate base rate based on hours or daily rate
        double baseRate = (hours <= 24) ? hours * HOURLY_RATE : DAILY_RATE;

        // Add additional charge for kilometers beyond 50 km
        double extraKmCharge = (km > 50) ? (km - 50) * 0.25 : 0;

        return baseRate + extraKmCharge;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nHourly Rate: €" + HOURLY_RATE +
                "\nDaily Rate: €" + DAILY_RATE;
    }
}
