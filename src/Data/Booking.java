
package Data;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private int bookingId;
    private int vehicleId;
    private int custNo;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private LocalDate returnDate;
    private LocalTime returnTime;
    private String pickUpLocation;

    public Booking(int bookingId, int vehicleId, int custNo, LocalDate pickUpDate, LocalTime pickUpTime, LocalDate returnDate, LocalTime returnTime, String pickUpLocation) {
        this.bookingId = bookingId;
        this.vehicleId = vehicleId;
        this.custNo = custNo;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
        this.pickUpLocation = pickUpLocation;
    }

    @Override
    public String toString() {
        return String.format("Booking ID: %d, Vehicle ID: %d, Customer No: %d, Pickup: %s %s, Return: %s %s, Location: %s",
                bookingId, vehicleId, custNo, pickUpDate, pickUpTime, returnDate, returnTime, pickUpLocation);
    }
}
