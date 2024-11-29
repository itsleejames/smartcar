
package Data;

import java.time.LocalDate;

public abstract class Petrol extends Vehicle {
    protected double engine;
    protected int co2;

    public Petrol(int id, String regNo, String manufacturer, String model, LocalDate regDate, Location location, double engine, int co2) {
        super(id, regNo, manufacturer, model, regDate, location);
        this.engine = engine;
        this.co2 = co2;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Engine: %.1fL, CO2: %d g/km", engine, co2);
    }
}
