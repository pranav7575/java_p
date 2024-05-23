import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Rentable {
    void rent();
    void returnVehicle();
    double calculateRentalCost(int days);
    boolean isRented();
}

class Car implements Rentable {
    private String model;
    private double dailyRate;
    private boolean isRented;

    public Car(String model, double dailyRate) {
        this.model = model;
        this.dailyRate = dailyRate;
        this.isRented = false;
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
        } else {
            System.out.println("Car is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
        } else {
            System.out.println("Car is not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }

    @Override
    public boolean isRented() {
        return isRented;
    }

    @Override
    public String toString() {
        return "Car [Model: " + model + ", Daily Rate: $" + dailyRate + ", Available: " + !isRented + "]";
    }
}

class Motorcycle implements Rentable {
    private String model;
    private double dailyRate;
    private boolean isRented;

    public Motorcycle(String model, double dailyRate) {
        this.model = model;
        this.dailyRate = dailyRate;
        this.isRented = false;
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
        } else {
            System.out.println("Motorcycle is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
        } else {
            System.out.println("Motorcycle is not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }

    @Override
    public boolean isRented() {
        return isRented;
    }

    @Override
    public String toString() {
        return "Motorcycle [Model: " + model + ", Daily Rate: $" + dailyRate + ", Available: " + !isRented + "]";
    }
}

class Bicycle implements Rentable {
    private String model;
    private double dailyRate;
    private boolean isRented;

    public Bicycle(String model, double dailyRate) {
        this.model = model;
        this.dailyRate = dailyRate;
        this.isRented = false;
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
        } else {
            System.out.println("Bicycle is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
        } else {
            System.out.println("Bicycle is not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }

    @Override
    public boolean isRented() {
        return isRented;
    }

    @Override
    public String toString() {
        return "Bicycle [Model: " + model + ", Daily Rate: $" + dailyRate + ", Available: " + !isRented + "]";
    }
}

class RentalManager {
    private List<Rentable> vehicles;

    public RentalManager() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Rentable vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added: " + vehicle);
    }

    public void rentVehicle(String model) {
        for (Rentable vehicle : vehicles) {
            if (vehicle.toString().contains(model) && !vehicle.isRented()) {
                vehicle.rent();
                System.out.println("Vehicle rented: " + vehicle);
                return;
            }
        }
        System.out.println("Vehicle not available or already rented.");
    }

    public void returnVehicle(String model) {
        for (Rentable vehicle : vehicles) {
            if (vehicle.toString().contains(model) && vehicle.isRented()) {
                vehicle.returnVehicle();
                System.out.println("Vehicle returned: " + vehicle);
                return;
            }
        }
        System.out.println("Vehicle not found or not rented.");
    }

    public void displayAvailableVehicles() {
        System.out.println("Available Vehicles:");
        for (Rentable vehicle : vehicles) {
            if (!vehicle.isRented()) {
                System.out.println(vehicle);
            }
        }
    }

    public void calculateRentalCost(String model, int days) {
        for (Rentable vehicle : vehicles) {
            if (vehicle.toString().contains(model)) {
                double cost = vehicle.calculateRentalCost(days);
                System.out.println("Rental cost for " + model + " for " + days + " days: $" + cost);
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalManager manager = new RentalManager();

        manager.addVehicle(new Car("Toyota Corolla", 50.0));
        manager.addVehicle(new Motorcycle("Yamaha R1", 30.0));
        manager.addVehicle(new Bicycle("Giant ATX", 10.0));

        while (true) {
            System.out.println("\nVehicle Rental System:");
            System.out.println("1. Add New Vehicle");
            System.out.println("2. Rent Vehicle");
            System.out.println("3. Return Vehicle");
            System.out.println("4. Display Available Vehicles");
            System.out.println("5. Calculate Rental Cost");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("1. Add Car");
                    System.out.println("2. Add Motorcycle");
                    System.out.println("3. Add Bicycle");
                    System.out.print("Enter your choice: ");
                    int vehicleType = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter daily rate: ");
                    double dailyRate = scanner.nextDouble();

                    switch (vehicleType) {
                        case 1:
                            manager.addVehicle(new Car(model, dailyRate));
                            break;
                        case 2:
                            manager.addVehicle(new Motorcycle(model, dailyRate));
                            break;
                        case 3:
                            manager.addVehicle(new Bicycle(model, dailyRate));
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                case 2:
                    System.out.print("Enter model to rent: ");
                    String rentModel = scanner.nextLine();
                    manager.rentVehicle(rentModel);
                    break;
                case 3:
                    System.out.print("Enter model to return: ");
                    String returnModel = scanner.nextLine();
                    manager.returnVehicle(returnModel);
                    break;
                case 4:
                    manager.displayAvailableVehicles();
                    break;
                case 5:
                    System.out.print("Enter model: ");
                    String costModel = scanner.nextLine();
                    System.out.print("Enter number of days: ");
                    int days = scanner.nextInt();
                    manager.calculateRentalCost(costModel, days);
                    break;
                case 6:
                    System.out.println("Thank you for using the vehicle rental system!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
