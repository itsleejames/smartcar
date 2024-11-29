
package Data;

public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String address;

    public Person(String firstName, String lastName, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s, Email: %s, Address: %s", firstName, lastName, email, address);
    }
}
