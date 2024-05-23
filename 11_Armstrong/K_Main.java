import java.util.*;

class ArmstrongOrNot {
    void checkArmstrong(int num) {
        int temp, sum = 0, digit = 0;
        temp = num;
        while (temp > 0) {
            temp = temp / 10;   
            digit++; 
        }
        temp = num;
        while (temp > 0) {
            int rem = temp % 10;
            sum += Math.pow(rem, digit);
            temp = temp / 10;
        }
        if (num == sum) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }
    }
}

class Anagrams {
    public void checkAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            System.out.println("Not Anagrams");
        } else {
            char[] s1 = str1.toCharArray();
            char[] s2 = str2.toCharArray();
            Arrays.sort(s1);
            Arrays.sort(s2);
            if (Arrays.equals(s1, s2)) {
                System.out.println("Anagrams");
            } else {
                System.out.println("Not Anagrams");
            }
        }
    }
}

class DOB {
    public void checkDOB() {
        // Implement the logic for comparing DOBs if needed
     Scanner scanner = new Scanner(System.in);

        // Take first DOB input from user
        System.out.print("Enter the first DOB (yyyy-mm-dd): ");
        String dob1 = scanner.nextLine();

        // Take second DOB input from user
        System.out.print("Enter the second DOB (yyyy-mm-dd): ");
        String dob2 = scanner.nextLine();

        // Compare the DOBs
        int comparisonResult = compareDates(dob1, dob2);

        if (comparisonResult < 0) {
            System.out.println("First person is Elder.");
        } else if (comparisonResult > 0) {
            System.out.println("First person is Younger.");
        } else {
            System.out.println("Both are of the Same age.");
        }

        scanner.close();
    }

    // Method to compare two dates in yyyy-mm-dd format
    public static int compareDates(String dob1, String dob2) {
        String[] parts1 = dob1.split("-");
        String[] parts2 = dob2.split("-");

        for (int i = 0; i < parts1.length; i++) {
            int part1 = Integer.parseInt(parts1[i]);
            int part2 = Integer.parseInt(parts2[i]);
            if (part1 < part2) {
                return -1;
            } else if (part1 > part2) {
                return 1;
            }
        }
        return 0;
    }
}

class Prime {
    public void checkPrime(int num) {
        if (num <= 1) {
            System.out.println("Not a Prime Number");
            return;
        }
        boolean isPrime = true;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println("Prime Number");
        } else {
            System.out.println("Not a Prime Number");
        }
    }
}

public class K_Main {
    public static void main(String[] args) {
        boolean m = true;
        Scanner scanner = new Scanner(System.in);

        while (m) {
            System.out.println("Choose the operation you want to perform:");
            System.out.println("1. Check Armstrong Number");
            System.out.println("2. Check Anagrams");
            System.out.println("3. Check Prime Number");
            System.out.println("4. Check DOB Number");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the number to check if it is an Armstrong number:");
                    int num = scanner.nextInt();
                    ArmstrongOrNot armstrongOrNot = new ArmstrongOrNot();
                    armstrongOrNot.checkArmstrong(num);
                    break;
                case 2:
                    System.out.println("Enter the two strings to check if they are anagrams:");
                    String str1 = scanner.next();
                    String str2 = scanner.next();
                    Anagrams anagrams = new Anagrams();
                    anagrams.checkAnagram(str1, str2);
                    break;
                case 3:
                    System.out.println("Enter the number to check if it is a prime number:");
                    int num1 = scanner.nextInt();
                    Prime prime = new Prime();
                    prime.checkPrime(num1);
                    break;
                case 4:
                    System.out.println("Enter the two dates to check which person is elder:");
                    DOB dob = new DOB();
                    dob.checkDOB();
                  
                case 5:
                    m = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
      
    }
}
