package Data;

// Abstract class Person to define common attributes for individuals
public abstract class Person {
    private String firstname; // First name of the person
    private String lastname;  // Last name of the person
    private String email;     // Email address of the person
    private String address;   // Address of the person

    // Constructor to initialize Person attributes
    public Person(String firstname, String lastname, String email, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
    }

    // Display person's details
    @Override
    public String toString() {
        return "First Name: " + firstname + "\n" +
                "Last Name: " + lastname + "\n" +
                "Email: " + email + "\n" +
                "Address: " + address + "\n";
    }
}
