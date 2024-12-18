package Data;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Vehicle> fleet = new ArrayList<>();
    private static ArrayList<Booking> bookings = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static int bookingCounter = 1;
    private static int vehicleCounter = 1;

    public static void main(String[] args) {
        showMainMenu();
    }

    private static void showMainMenu() {
        boolean exit = false;

        while (!exit) {
            String[] options = {"Customer Menu", "Employee Menu", "Exit"};
            int choice = JOptionPane.showOptionDialog(
                    null, "Welcome to SmartCar System", "Main Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]
            );

            switch (choice) {
                case 0 -> showCustomerMenu();
                case 1 -> showEmployeeMenu();
                case 2 -> exit = true;
                default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
    }

    private static void showCustomerMenu() {
        String[] options = {"Sign Up", "Book a Car", "Return a Car", "Back"};
        int choice = JOptionPane.showOptionDialog(
                null, "Customer Menu", "Customer Options",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]
        );

        switch (choice) {
            case 0 -> signUpCustomer();
            case 1 -> bookCar();
            case 2 -> returnCar();
            default -> JOptionPane.showMessageDialog(null, "Returning to main menu.");
        }
    }

    private static void showEmployeeMenu() {
        String[] options = {"Add a Vehicle", "Change Rates", "List Bookings", "List Customers", "List Vehicles", "List Employees", "Back"};
        int choice = JOptionPane.showOptionDialog(
                null, "Employee Menu", "Employee Options",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]
        );

        switch (choice) {
            case 0 -> addVehicle();
            case 1 -> changeRates();
            case 2 -> listBookings();
            case 3 -> listCustomers();
            case 4 -> listVehicles();
            case 5 -> listEmployees();
            default -> JOptionPane.showMessageDialog(null, "Returning to main menu.");
        }
    }

    private static void signUpCustomer() {
        String firstName = JOptionPane.showInputDialog("Enter First Name:");
        String lastName = JOptionPane.showInputDialog("Enter Last Name:");
        String email = JOptionPane.showInputDialog("Enter Email:");
        String address = JOptionPane.showInputDialog("Enter Address:");
        int custNo = customers.size() + 1;
        customers.add(new Customer(firstName, lastName, email, address, custNo));
        JOptionPane.showMessageDialog(null, "Sign-up successful. Your customer number is " + custNo);
    }

    private static void bookCar() {
        try {
            int custNo = Integer.parseInt(JOptionPane.showInputDialog("Enter Customer Number:"));
            int vehicleId = Integer.parseInt(JOptionPane.showInputDialog("Enter Vehicle ID:"));
            String location = JOptionPane.showInputDialog("Enter Pick-up Location:");
            LocalDate pickUpDate = LocalDate.parse(JOptionPane.showInputDialog("Enter Pick-up Date (yyyy-mm-dd):"));
            LocalTime pickUpTime = LocalTime.parse(JOptionPane.showInputDialog("Enter Pick-up Time (HH:mm):"));
            LocalDate returnDate = LocalDate.parse(JOptionPane.showInputDialog("Enter Return Date (yyyy-mm-dd):"));
            LocalTime returnTime = LocalTime.parse(JOptionPane.showInputDialog("Enter Return Time (HH:mm):"));

            bookings.add(new Booking(bookingCounter++, vehicleId, custNo, pickUpDate, pickUpTime, returnDate, returnTime, location));
            JOptionPane.showMessageDialog(null, "Booking successful!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please try again.");
        }
    }

    private static void returnCar() {
        JOptionPane.showMessageDialog(null, "Return a Car functionality coming soon!");
    }

    private static void addVehicle() {
        JOptionPane.showMessageDialog(null, "Add a Vehicle functionality coming soon!");
    }

    private static void changeRates() {
        JOptionPane.showMessageDialog(null, "Change Rates functionality coming soon!");
    }

    private static void listBookings() {
        String result = "List of Bookings:\n";
        for (Booking booking : bookings) {
            result += booking + "\n";
        }
        JOptionPane.showMessageDialog(null, result);
    }

    private static void listCustomers() {
        String result = "List of Customers:\n";
        for (Customer customer : customers) {
            result += customer + "\n";
        }
        JOptionPane.showMessageDialog(null, result);
    }

    private static void listVehicles() {
        String result = "List of Vehicles:\n";
        for (Vehicle vehicle : fleet) {
            result += vehicle + "\n";
        }
        JOptionPane.showMessageDialog(null, result);
    }

    private static void listEmployees() {
        String result = "List of Employees:\n";
        for (Employee employee : employees) {
            result += employee + "\n";
        }
        JOptionPane.showMessageDialog(null, result);
    }
}
