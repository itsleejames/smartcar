import java.time.LocalDate;

public class Booking {
    private int bookingId;
    private int vehicleId;
    private int custNo;
    private LocalDate pickUpDate;
    private LocalDate returnDate;
    private String pickUpLocation;

    // Constructor
    public Booking(int bookingId, int vehicleId, int custNo, LocalDate pickUpDate, LocalDate returnDate, String pickUpLocation) {
        this.bookingId = bookingId;
        this.vehicleId = vehicleId;
        this.custNo = custNo;
        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.pickUpLocation = pickUpLocation;
    }

    // Getters
    public int getBookingId() {
        return bookingId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public int getCustNo() {
        return custNo;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    // Setters
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setCustNo(int custNo) {
        this.custNo = custNo;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    // Method forr booking details
    public String displayBookingDetails() {
        return "Booking ID: " + bookingId + "\n" +
                "Vehicle ID: " + vehicleId + "\n" +
                "Customer Number: " + custNo + "\n" +
                "Pick Up Date: " + pickUpDate + "\n" +
                "Return Date: " + returnDate + "\n" +
                "Pick Up Location: " + pickUpLocation;
    }
}
