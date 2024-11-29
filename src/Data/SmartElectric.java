
package Data;

import java.time.LocalDate;

public class SmartElectric extends Vehicle {
    private static final double HOURLY_RATE = 14.0;
    private static final double DAILY_RATE = 70.0;
    private double battery;
    private int range;
    private int efficiency;

    public SmartElectric(int id, String regNo, String manufacturer, String model, LocalDate regDate, Location location, double battery, int range, int efficiency) {
        super(id, regNo, manufacturer, model, regDate, location);
        this.battery = battery;
        this.range = range;
        this.efficiency = efficiency;
    }

    @Override
    public double calculateRate(int hours, int kilometers) {
        return (hours <= 24) ? hours * HOURLY_RATE : DAILY_RATE;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Battery: %.1f kWh, Range: %d km, Efficiency: %d kWh/km", battery, range, efficiency);
    }
}
