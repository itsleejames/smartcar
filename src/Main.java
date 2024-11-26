import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        // Populate data
        populateData();

        // Display main menu
        while (true) {
            String[] options = {"Customer", "Employee", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Welcome to SmartCar System. Please choose:", "SmartCar System",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                customerMenu();
            } else if (choice == 1) {
                employeeMenu();
            } else {
                JOptionPane.showMessageDialog(null, "Thank you for using the SmartCar System!");
                break;
            }
        }
    }

    private static void customerMenu() {
        String[] options = {"Sign Up", "Book a Car", "Return a Car", "Back"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(null, "Customer Menu", "Customer Options",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                signUpCustomer();
            } else if (choice == 1) {
                bookCar();
            } else if (choice == 2) {
                returnCar();
            } else {
                break;
            }
        }
    }

    private static void employeeMenu() {
        String[] options = {"List Bookings", "List Customers", "Back"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(null, "Employee Menu", "Employee Options",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                listBookings();
            } else if (choice == 1) {
                listCustomers();
            } else {
                break;
            }
        }
    }

    private static void populateData() {
        // Add customers
        customers.add(new Customer("John", "Doe", "john.doe@example.com", "123 Main St", 1));

        // Add employees
        employees.add(new Employee("Jane", "Smith", "jane.smith@example.com", "456 Elm St", 1) {
            @Override
            public String displayDetails() {
                return null;
            }
        });

        // Add bookings
        bookings.add(new Booking(1, 1, 1, LocalDate.of(2024, 11, 20), LocalDate.of(2024, 11, 21), "Limerick"));
    }

    private static void signUpCustomer() {
        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        String lastName = JOptionPane.showInputDialog("Enter your last name:");
        String email = JOptionPane.showInputDialog("Enter your email:");
        String address = JOptionPane.showInputDialog("Enter your address:");
        int custNo = customers.size() + 1;

        Customer newCustomer = new Customer(firstName, lastName, email, address, custNo);
        customers.add(newCustomer);
        JOptionPane.showMessageDialog(null, "Customer added successfully! Your customer number is: " + custNo);
    }

    private static void bookCar() {
        JOptionPane.showMessageDialog(null, "Booking functionality is under development.");
    }

    private static void returnCar() {
        JOptionPane.showMessageDialog(null, "Car return functionality is under development.");
    }

    private static void listBookings() {
        StringBuilder sb = new StringBuilder("List of Bookings:\n");
        for (Booking booking : bookings) {
            sb.append(booking.displayBookingDetails()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString().isEmpty() ? "No bookings available." : sb.toString());
    }

    private static void listCustomers() {
        StringBuilder sb = new StringBuilder("List of Customers:\n");
        for (Customer customer : customers) {
            sb.append(customer.displayCustomerDetails()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString().isEmpty() ? "No customers available." : sb.toString());
    }
}
