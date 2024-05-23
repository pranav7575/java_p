import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected String employeeID;

    public Employee(String name, String employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }

    public abstract double calculateSalary();
    public abstract void evaluatePerformance();
    public abstract void displayEmployeeDetails();
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;
    private double performanceBonus;

    public FullTimeEmployee(String name, String employeeID, double monthlySalary, double performanceBonus) {
        super(name, employeeID);
        this.monthlySalary = monthlySalary;
        this.performanceBonus = performanceBonus;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary + performanceBonus;
    }

    @Override
    public void evaluatePerformance() {
        System.out.println("Evaluating performance for full-time employee " + name);
        // Simple performance evaluation logic
        System.out.println(name + " has met performance expectations.");
    }

    @Override
    public void displayEmployeeDetails() {
        System.out.println("FullTimeEmployee{" +
                "name='" + name + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", monthlySalary=" + monthlySalary +
                ", performanceBonus=" + performanceBonus +
                ", totalSalary=" + calculateSalary() +
                '}');
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, String employeeID, double hourlyRate, int hoursWorked) {
        super(name, employeeID);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void evaluatePerformance() {
        // Performance evaluation not applicable for part-time employees
        System.out.println("Performance evaluation is not applicable for part-time employees.");
    }

    @Override
    public void displayEmployeeDetails() {
        System.out.println("PartTimeEmployee{" +
                "name='" + name + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", hourlyRate=" + hourlyRate +
                ", hoursWorked=" + hoursWorked +
                ", totalSalary=" + calculateSalary() +
                '}');
    }
}



public class O_Main {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Register Employee");
            System.out.println("2. Calculate Salary");
            System.out.println("3. Evaluate Performance");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    registerEmployee();
                    break;
                case 2:
                    calculateSalaries();
                    break;
                case 3:
                    evaluatePerformances();
                    break;
                case 4:
                    displayAllEmployees();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerEmployee() {
        System.out.println("1. Full-Time Employee");
        System.out.println("2. Part-Time Employee");
        System.out.print("Choose type of employee: ");
        int type = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();

        switch (type) {
            case 1:
                System.out.print("Enter monthly salary: ");
                double monthlySalary = scanner.nextDouble();
                System.out.print("Enter performance bonus: ");
                double performanceBonus = scanner.nextDouble();
                employees.add(new FullTimeEmployee(name, employeeID, monthlySalary, performanceBonus));
                break;
            case 2:
                System.out.print("Enter hourly rate: ");
                double hourlyRate = scanner.nextDouble();
                System.out.print("Enter hours worked: ");
                int hoursWorked = scanner.nextInt();
                employees.add(new PartTimeEmployee(name, employeeID, hourlyRate, hoursWorked));
                break;
            default:
                System.out.println("Invalid type. Employee not registered.");
        }
    }

    private static void calculateSalaries() {
        for (Employee employee : employees) {
            System.out.println(employee.name + "'s salary: " + employee.calculateSalary());
        }
    }

    private static void evaluatePerformances() {
        for (Employee employee : employees) {
            employee.evaluatePerformance();
        }
    }

    private static void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employees) {
                employee.displayEmployeeDetails();
            }
        }
    }
}
