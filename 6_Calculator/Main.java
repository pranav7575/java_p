import java.util.Scanner;
// Calculator class
class Calculator {
    // Constant for PI
    static final double PI = 3.14;

    // Static block to print welcome message
    static {
        System.out.println("Welcome to the Simple Calculator!");
    }

    // Instance block to print message when a new instance is created
    {
        System.out.println("New calculator instance");
    }

    // Constructor
    public Calculator() {
        // No need to implement anything in the constructor
    }

    // Method to add two numbers
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    // Method to subtract two numbers
    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // Method to multiply two numbers
    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    // Method to divide two numbers
    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return num1 / num2;
    }
}

// Main class to demonstrate the calculator
 class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an instance of Calculator
        Calculator calculator = new Calculator();

        while (true) {
            // Display menu
            System.out.println("\nCalculator Menu:");
            System.out.println("A. Addition");
            System.out.println("B. Subtraction");
            System.out.println("C. Multiplication");
            System.out.println("D. Division");
            System.out.println("E. Exit");
            System.out.print("Enter your choice (A/B/C/D/E): ");
            char choice = scanner.next().charAt(0);

            // Perform action based on user's choice
            switch (choice) {
                case 'A':
                    System.out.print("Enter first number: ");
                    double num1Add = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    double num2Add = scanner.nextDouble();
                    System.out.println("Result: " + Calculator.add(num1Add, num2Add));
                    break;
                case 'B':
                    System.out.print("Enter first number: ");
                    double num1Sub = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    double num2Sub = scanner.nextDouble();
                    System.out.println("Result: " + Calculator.subtract(num1Sub, num2Sub));
                    break;
                case 'C':
                    System.out.print("Enter first number: ");
                    double num1Mul = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    double num2Mul = scanner.nextDouble();
                    System.out.println("Result: " + Calculator.multiply(num1Mul, num2Mul));
                    break;
                case 'D':
                    System.out.print("Enter first number: ");
                    double num1Div = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    double num2Div = scanner.nextDouble();
                    try {
                        System.out.println("Result: " + Calculator.divide(num1Div, num2Div));
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 'E':
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
