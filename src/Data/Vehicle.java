
package Data;

import java.time.LocalDate;

public abstract class Vehicle {
    protected int id;
    protected String regNo;
    protected String manufacturer;
    protected String model;
    protected LocalDate regDate;
    protected Location location;

    public Vehicle(int id, String regNo, String manufacturer, String model, LocalDate regDate, Location location) {
        this.id = id;
        this.regNo = regNo;
        this.manufacturer = manufacturer;
        this.model = model;
        this.regDate = regDate;
        this.location = location;
    }

    public abstract double calculateRate(int hours, int kilometers);

    @Override
    public String toString() {
        return String.format("ID: %d, RegNo: %s, Manufacturer: %s, Model: %s, Location: %s", id, regNo, manufacturer, model, location);
    }
}
