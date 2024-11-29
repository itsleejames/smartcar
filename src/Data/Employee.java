
package Data;

public class Employee extends Person {
    private int empNo;

    public Employee(String firstName, String lastName, String email, String address, int empNo) {
        super(firstName, lastName, email, address);
        this.empNo = empNo;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Employee No: %d", empNo);
    }
}
