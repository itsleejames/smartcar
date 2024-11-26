public abstract class Employee extends Person {
    private int empNo;

    // Constructor
    public Employee(String firstName, String lastName, String email, String address, int empNo) {
        super(firstName, lastName, email, address); // Calls the constructor of the Person class
        this.empNo = empNo;
    }

    // Getter
    public int getEmpNo() {
        return empNo;
    }

    // Setter
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    // Method to display employee details
    public String displayEmployeeDetails() {
        return "Employee Number: " + empNo + "\n" +
                "Name: " + firstName + " " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Address: " + address;
    }
}
