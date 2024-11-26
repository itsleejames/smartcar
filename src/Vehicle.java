import java.time.LocalDate;
import java.util.ArrayList;

// Abstract Vehicle Class
abstract class Vehicle {
    protected int id;
    protected String regNo;
    protected String manufacturer;
    protected String model;
    protected LocalDate regDate;
    protected String location;

    public Vehicle(int id, String regNo, String manufacturer, String model, LocalDate regDate, String location) {
        this.id = id;
        this.regNo = regNo;
        this.manufacturer = manufacturer;
        this.model = model;
        this.regDate = regDate;
        this.location = location;
    }

    public abstract double calculateRate(int duration, double distance);
}








