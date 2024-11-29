package Data;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Vehicle> fleet = new ArrayList<>(); // List of all vehicles
    private static ArrayList<Booking> bookings = new ArrayList<>(); // List of all bookings
    private static ArrayList<Customer> customers = new ArrayList<>(); // List of all customers
    private static ArrayList<Employee> employees = new ArrayList<>(); // List of all employees
    private static ArrayList<SmartCity> cityVehicles = new ArrayList<>();
    private static ArrayList<SmartTripper> tripperVehicles = new ArrayList<>();
    private static ArrayList<SmartElectric> electricVehicles = new ArrayList<>();
    private static ArrayList<SmartVan> vanVehicles = new ArrayList<>();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            String[] options = {"Customer Menu", "Employee Menu", "Exit"}; // Main menu options
            int choice = JOptionPane.showOptionDialog(
                    null, "Select an option", "SmartCar System",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0 -> customerMenu();
                case 1 -> employeeMenu();
                case 2 -> exit = true;
                default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
            }
        }
    }

    private static void customerMenu() {
        boolean back = false;
        while (!back) {
            String[] options = {"Sign up", "Book Vehicle", "View Bookings", "Back"}; // Customer menu options
            int choice = JOptionPane.showOptionDialog(
                    null, "Select an option", "Customer Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0 -> signUp();
                case 1 -> bookVehicle();
                case 2 -> viewBookings();
                case 3 -> back = true;
                default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
            }
        }
    }

    private static void signUp() {
        String firstname = JOptionPane.showInputDialog("Enter your first name");
        String lastname = JOptionPane.showInputDialog("Enter your last name");
        String email = JOptionPane.showInputDialog("Enter your email address");
        String address = JOptionPane.showInputDialog("Enter your address");
        int custNo = customers.size() + 1;

        Customer customer = new Customer(firstname, lastname, email, address, custNo);
        customers.add(customer);

        JOptionPane.showMessageDialog(null, "Sign-up successful");
        System.out.println(customers);
    }

    private static void viewBookings() {
        if (bookings.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No bookings found");
        } else {
            for (Booking booking : bookings) {
                JOptionPane.showMessageDialog(null, booking);
            }
        }
    }

    private static void bookVehicle() {
        String[] vehicleTypes = {"City", "Tripper", "Electric", "Van"}; // Vehicle types
        int choice = JOptionPane.showOptionDialog(
                null, "Select a vehicle type", "Book Vehicle",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, vehicleTypes, vehicleTypes[0]);

        ArrayList<? extends Vehicle> selectedVehicles;
        switch (choice) {
            case 0 -> selectedVehicles = cityVehicles;
            case 1 -> selectedVehicles = tripperVehicles;
            case 2 -> selectedVehicles = electricVehicles;
            case 3 -> selectedVehicles = vanVehicles;
            default -> {
                JOptionPane.showMessageDialog(null, "Invalid option selected");
                return;
            }
        }

        try {
            int vehicleId = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the vehicle you want to book"));
            for (Vehicle vehicle : selectedVehicles) {
                if (vehicle.getVehicleId() == vehicleId) {
                    completeBooking(vehicle);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Vehicle not found");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void completeBooking(Vehicle vehicle) {
        try {
            int custNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your customer number"));
            LocalDate pickUpDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the pick-up date (yyyy-mm-dd)"));
            LocalTime pickUpTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the pick-up time (hh:mm)"));
            LocalDate returnDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the return date (yyyy-mm-dd)"));
            LocalTime returnTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the return time (hh:mm)"));
            String pickUpLocation = JOptionPane.showInputDialog("Enter the pick-up location");

            int bookingId = bookings.size() + 1;
            double rate = vehicle.calculateRate(
                    (int) Duration.between(LocalDateTime.of(pickUpDate, pickUpTime), LocalDateTime.of(returnDate, returnTime)).toHours(),
                    0
            );

            Booking booking = new Booking(bookingId, vehicle.getVehicleId(), custNo, pickUpDate, pickUpTime, returnDate, returnTime, pickUpLocation, rate);
            bookings.add(booking);

            JOptionPane.showMessageDialog(null, "Booking successful");
            System.out.println(bookings);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error processing booking", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void employeeMenu() {
        boolean back = false;
        while (!back) {
            String[] options = {"Add Vehicle", "Remove Vehicle", "View Bookings", "Add Employee", "Remove Employee", "View Employees", "Back"};
            int choice = JOptionPane.showOptionDialog(
                    null, "Select an option", "Employee Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0 -> addVehicle();
                case 1 -> removeVehicle();
                case 2 -> viewBookings();
                case 3 -> addEmployee();
                case 4 -> removeEmployee();
                case 5 -> viewEmployees();
                case 6 -> back = true;
                default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
            }
        }
    }

    private static void addEmployee() {
        String firstname = JOptionPane.showInputDialog("Enter the first name of the employee");
        String lastname = JOptionPane.showInputDialog("Enter the last name of the employee");
        String email = JOptionPane.showInputDialog("Enter the email address of the employee");
        String address = JOptionPane.showInputDialog("Enter the address of the employee");
        int empNo = employees.size() + 1;

        Employee employee = new Employee(firstname, lastname, email, address, empNo);
        employees.add(employee);

        JOptionPane.showMessageDialog(null, "Employee added successfully");
        System.out.println(employees);
    }

    private static void removeEmployee() {
        try {
            int empNo = Integer.parseInt(JOptionPane.showInputDialog("Enter the employee number you want to remove"));
            employees.removeIf(employee -> employee.getEmpNo() == empNo);
            JOptionPane.showMessageDialog(null, "Employee removed successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void viewEmployees() {
        if (employees.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No employees found");
        } else {
            for (Employee employee : employees) {
                JOptionPane.showMessageDialog(null, employee);
            }
        }
    }

    private static void addVehicle() {
        String[] vehicleTypes = {"City", "Tripper", "Electric", "Van"};
        int choice = JOptionPane.showOptionDialog(
                null, "Select a vehicle type", "Add Vehicle",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, vehicleTypes, vehicleTypes[0]);

        switch (choice) {
            case 0 -> cityVehicles.add(createCityVehicle());
            case 1 -> tripperVehicles.add(createTripperVehicle());
            case 2 -> electricVehicles.add(createElectricVehicle());
            case 3 -> vanVehicles.add(createVanVehicle());
            default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
        }
    }

    private static SmartCity createCityVehicle() {
        // Logic to create a SmartCity instance
        return null; // Replace with actual implementation
    }

    private static SmartTripper createTripperVehicle() {
        // Logic to create a SmartTripper instance
        return null; // Replace with actual implementation
    }

    private static SmartElectric createElectricVehicle() {
        // Logic to create a SmartElectric instance
        return null; // Replace with actual implementation
    }

    private static SmartVan createVanVehicle() {
        // Logic to create a SmartVan instance
        return null; // Replace with actual implementation
    }

    private static void removeVehicle() {
        try {
            int vehicleId = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the vehicle you want to remove"));
            fleet.removeIf(vehicle -> vehicle.getVehicleId() == vehicleId);
            JOptionPane.showMessageDialog(null, "Vehicle removed successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
