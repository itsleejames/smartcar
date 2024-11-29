package Data;

// Employee class is a subclass of Person class
public class Employee extends Person {
    private int empNo; // Employee number

    // Constructor
    public Employee(String firstname, String lastname, String email, String address, int empNo) {
        super(firstname, lastname, email, address);
        this.empNo = empNo; // Set the employee number
    }

    // Display employee details
    @Override
    public String toString() {
        return "Employee ID: " + empNo + "\n" + super.toString();
    }

    // Getter for employee number
    public int getEmpNo() {
        return empNo;
    }

    // Setter for employee number
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
}
