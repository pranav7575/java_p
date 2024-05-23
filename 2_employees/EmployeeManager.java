
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Define the Employee base class
class Employee {
    private String name;
    private int employeeID;
    private double hourlyRate;

    public Employee(String name, int employeeID, double hourlyRate) {
        this.name = name;
        this.employeeID = employeeID;
        this.hourlyRate = hourlyRate;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double calculateMonthlySalary() {
        return 0; // This method will be overridden in subclasses
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', employeeID=" + employeeID + ", hourlyRate=" + hourlyRate + '}';
    }
}

// Define the FullTimeEmployee class that extends Employee
class FullTimeEmployee extends Employee {
    private double salary;
    private String benefits;

    public FullTimeEmployee(String name, int employeeID, double hourlyRate, double salary, String benefits) {
        super(name, employeeID, hourlyRate);
        this.salary = salary;
        this.benefits = benefits;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    @Override
    public double calculateMonthlySalary() {
        return getSalary();
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" + "name='" + getName() + "', employeeID=" + getEmployeeID() +
                ", hourlyRate=" + getHourlyRate() + ", salary=" + salary + ", benefits='" + benefits + '\'' + '}';
    }
}

// Define the PartTimeEmployee class that extends Employee
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double overtimeRate;

    public PartTimeEmployee(String name, int employeeID, double hourlyRate, int hoursWorked, double overtimeRate) {
        super(name, employeeID, hourlyRate);
        this.hoursWorked = hoursWorked;
        this.overtimeRate = overtimeRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }

    public void setOvertimeRate(double overtimeRate) {
        this.overtimeRate = overtimeRate;
    }

    @Override
    public double calculateMonthlySalary() {
        int regularHours = Math.min(hoursWorked, 160);
        int overtimeHours = Math.max(hoursWorked - 160, 0);
        return (regularHours * getHourlyRate()) + (overtimeHours * getOvertimeRate());
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" + "name='" + getName() + "', employeeID=" + getEmployeeID() +
                ", hourlyRate=" + getHourlyRate() + ", hoursWorked=" + hoursWorked + ", overtimeRate=" + overtimeRate + '}';
    }
}

// EmployeeManager class to manage the list of employees
 class EmployeeManager {
    private List<Employee> employees=new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void displayEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
            System.out.println("Monthly Salary: " + employee.calculateMonthlySalary());
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String ftName = scanner.nextLine();
                    System.out.print("Enter employee ID: ");
                    int ftID = scanner.nextInt();
                    System.out.print("Enter hourly rate: ");
                    double ftHourlyRate = scanner.nextDouble();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter benefits: ");
                    String benefits = scanner.nextLine();
                    manager.addEmployee(new FullTimeEmployee(ftName, ftID, ftHourlyRate, salary, benefits));
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    String ptName = scanner.nextLine();
                    System.out.print("Enter employee ID: ");
                    int ptID = scanner.nextInt();
                    System.out.print("Enter hourly rate: ");
                    double ptHourlyRate = scanner.nextDouble();
                    System.out.print("Enter hours worked: ");
                    int hoursWorked = scanner.nextInt();
                    System.out.print("Enter overtime rate: ");
                    double overtimeRate = scanner.nextDouble();
                    manager.addEmployee(new PartTimeEmployee(ptName, ptID, ptHourlyRate, hoursWorked, overtimeRate));
                    break;
                case 3:
                    manager.displayEmployees();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
