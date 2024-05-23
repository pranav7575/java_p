import java.util.Scanner;

class AdditionThread extends Thread {
    private double num1, num2;

    public AdditionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void run() {
        System.out.println("Addition result: " + (num1 + num2));
    }
}

class SubtractionThread extends Thread {
    private double num1, num2;

    public SubtractionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void run() {
        System.out.println("Subtraction result: " + (num1 - num2));
    }
}

class MultiplicationThread extends Thread {
    private double num1, num2;

    public MultiplicationThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void run() {
        System.out.println("Multiplication result: " + (num1 * num2));
    }
}

class DivisionThread extends Thread {
    private double num1, num2;

    public DivisionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void run() {
        if (num2 == 0) {
            System.out.println("Division result: Error (division by zero)");
        } else {
            System.out.println("Division result: " + (num1 / num2));
        }
    }
}

public class MultithreadedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = 0, num2 = 0;
        boolean validInput = false;

        // Input validation for numbers
        while (!validInput) {
            try {
                System.out.print("Enter first number: ");
                num1 = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter second number: ");
                num2 = Double.parseDouble(scanner.nextLine());

                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric values.");
            }
        }

        int choice = 0;
        boolean validChoice = false;

        // Input validation for operation choice
        while (!validChoice) {
            System.out.println("Choose an operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 4) {
                    validChoice = true;
                } else {
                    System.out.println("Invalid choice. Please choose a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        // Create and start the appropriate thread based on user's choice
        switch (choice) {
            case 1:
                new AdditionThread(num1, num2).start();
                break;
            case 2:
                new SubtractionThread(num1, num2).start();
                break;
            case 3:
                new MultiplicationThread(num1, num2).start();
                break;
            case 4:
                new DivisionThread(num1, num2).start();
                break;
        }

        scanner.close();
    }
}
