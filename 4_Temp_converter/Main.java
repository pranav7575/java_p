import java.util.Scanner;

// Custom exception class for handling invalid temperature input
class InvalidTemperatureException extends Exception {
    public InvalidTemperatureException(String message) {
        super(message);
    }
}
// TemperatureConverter class to perform temperature conversions
class TemperatureConverter {
    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}

// Main class to handle user input and temperature conversions
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Temperature Converter");
            System.out.println("1. Convert Celsius to Fahrenheit");
            System.out.println("2. Convert Fahrenheit to Celsius");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter temperature: ");
            double temperature = scanner.nextDouble();

            try {
                if (temperature < -273.15 || temperature > 1000) {
                    throw new InvalidTemperatureException("Temperature value is outside the valid range");
                }

                switch (choice) {
                    case 1:
                        double fahrenheit = TemperatureConverter.celsiusToFahrenheit(temperature);
                        System.out.println("Result: " + fahrenheit + "°F");
                        break;
                    case 2:
                        double celsius = TemperatureConverter.fahrenheitToCelsius(temperature);
                        System.out.println("Result: " + celsius + "°C");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InvalidTemperatureException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
}
