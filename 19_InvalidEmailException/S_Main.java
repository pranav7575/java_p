//Write a Java program for user defined excision for valid email address.
//The program should have the following features:
//1. The program should take an email address as input from the user.
//2. The program should check whether the given email address is valid or not.
//3. The program should print "Valid Email Address" if the given email address is valid, otherwise it should print "Invalid Email Address".
//Example
//Input
//vit.edu@
//Output please enter valid email address
//program
import java.util.Scanner;

// Define the custom exception InvalidEmailException
class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

// Main class to validate email addresses
public class S_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter an email address
        System.out.print("Enter an email address: ");
        String email = scanner.nextLine();

        try {
            // Validate the email address
            validateEmail(email);
            System.out.println("The email address is valid.");
        } catch (InvalidEmailException e) {
            // Handle the custom exception
            System.out.println(e.getMessage());
        }
    }

    // Method to validate the email address
    public static void validateEmail(String email) throws InvalidEmailException {
        // Check if the email contains '@' and '.'
        if (email.indexOf('@') < 0 || email.indexOf('.') < 0) {
            throw new InvalidEmailException("Please enter a valid email address.");
        }

        // Check if '@' comes before '.'
        if (email.indexOf('@') > email.lastIndexOf('.')) {
            throw new InvalidEmailException("Please enter a valid email address.");
        }
    }
}
