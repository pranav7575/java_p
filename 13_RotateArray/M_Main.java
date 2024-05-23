import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class M_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for array size and elements
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        while (true) {
            // Display the menu
            System.out.println("\nChoose an operation to perform:");
            System.out.println("1. Rotate the elements of the array to the right by a specified number of positions");
            System.out.println("2. Remove duplicate elements from the array while preserving the original order");
            System.out.println("3. Rearrange the elements of the array such that all even numbers appear before all odd numbers, preserving the relative order");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of positions to rotate to the right: ");
                    int positions = scanner.nextInt();
                    array = rotateRight(array, positions);
                    System.out.println("Array after rotation: " + arrayToString(array));
                    break;
                case 2:
                    array = removeDuplicates(array);
                    System.out.println("Array after removing duplicates: " + arrayToString(array));
                    break;
                case 3:
                    array = rearrangeEvenOdd(array);
                    System.out.println("Array after rearranging even and odd numbers: " + arrayToString(array));
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

    // Method to rotate the elements of the array to the right by a specified number of positions
    public static int[] rotateRight(int[] array, int positions) {
        int length = array.length;
        int[] rotatedArray = new int[length];
        for (int i = 0; i < length; i++) {
            rotatedArray[(i + positions) % length] = array[i];
        }
        return rotatedArray;
    }

    // Method to remove duplicate elements from the array while preserving the original order
    public static int[] removeDuplicates(int[] array) {
        Set<Integer> seen = new LinkedHashSet<>();
        for (int num : array) {
            seen.add(num);
        }
        int[] result = new int[seen.size()];
        int index = 0;
        for (int num : seen) {
            result[index++] = num;
        }
        return result;
    }

    // Method to rearrange the elements of the array such that all even numbers appear before all odd numbers
    public static int[] rearrangeEvenOdd(int[] array) {
        ArrayList<Integer> evenList = new ArrayList<>();
        ArrayList<Integer> oddList = new ArrayList<>();
        for (int num : array) {
            if (num % 2 == 0) {
                evenList.add(num);
            } else {
                oddList.add(num);
            }
        }
        evenList.addAll(oddList);
        int[] rearrangedArray = new int[evenList.size()];
        for (int i = 0; i < evenList.size(); i++) {
            rearrangedArray[i] = evenList.get(i);
        }
        return rearrangedArray;
    }

    // Utility method to convert array to string
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }
}

