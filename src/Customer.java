public class Customer extends Person {
    private int custNo;

    // Constructor
    public Customer(String firstName, String lastName, String email, String address, int custNo) {
        super(firstName, lastName, email, address); // Calls the constructor of the Person class
        this.custNo = custNo;
    }

    // Getter
    public int getCustNo() {
        return custNo;
    }

    // Setter
    public void setCustNo(int custNo) {
        this.custNo = custNo;
    }

    // Override displayDetails method from Person class
    @Override
    public String displayDetails() {
        return "Customer Number: " + custNo + "\n" +
                "Name: " + firstName + " " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Address: " + address;
    }
}
