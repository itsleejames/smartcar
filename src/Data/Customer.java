
package Data;

public class Customer extends Person {
    private int custNo;

    public Customer(String firstName, String lastName, String email, String address, int custNo) {
        super(firstName, lastName, email, address);
        this.custNo = custNo;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Customer No: %d", custNo);
    }
}
