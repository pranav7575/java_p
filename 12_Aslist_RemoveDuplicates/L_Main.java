import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class L_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Sample elements for demonstration
        arrayList.addAll(Arrays.asList(10, 20, 10, 15, 40, 15, 40));

        while (true) {
            // Display the menu
            System.out.println("\nMenu:");
            System.out.println("1. Check if an element exists");
            System.out.println("2. Add element at a particular index");
            System.out.println("3. Remove element at a particular index");
            System.out.println("4. Sort the ArrayList");
            System.out.println("5. Reverse the ArrayList");
            System.out.println("6. Compare with another ArrayList");
            System.out.println("7. Find first and last occurrence of an element");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to check existence: ");
                    int elementToCheck = scanner.nextInt();
                    System.out.println("Element exists: " + arrayList.contains(elementToCheck));
                    break;

                case 2:
                    System.out.print("Enter index to add element: ");
                    int indexToAdd = scanner.nextInt();
                    System.out.print("Enter element to add: ");
                    int elementToAdd = scanner.nextInt();
                    if (indexToAdd >= 0 && indexToAdd <= arrayList.size()) {
                        arrayList.add(indexToAdd, elementToAdd);
                        System.out.println("ArrayList after adding element: " + arrayList);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 3:
                    System.out.print("Enter index to remove element: ");
                    int indexToRemove = scanner.nextInt();
                    if (indexToRemove >= 0 && indexToRemove < arrayList.size()) {
                        arrayList.remove(indexToRemove);
                        System.out.println("ArrayList after removing element: " + arrayList);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 4:
                    Collections.sort(arrayList);
                    System.out.println("ArrayList after sorting: " + arrayList);
                    break;

                case 5:
                    Collections.reverse(arrayList);
                    System.out.println("ArrayList after reversing: " + arrayList);
                    break;

                case 6:
                    ArrayList<Integer> anotherList = new ArrayList<>();
                    System.out.println("Enter elements for another ArrayList (enter -1 to stop): ");
                    while (true) {
                        int element = scanner.nextInt();
                        if (element == -1) break;
                        anotherList.add(element);
                    }
                    System.out.println("Another ArrayList: " + anotherList);
                    System.out.println("Are both ArrayLists equal: " + arrayList.equals(anotherList));
                    break;

                case 7:
                    System.out.print("Enter element to find first and last occurrence: ");
                    int elementToFind = scanner.nextInt();
                    System.out.println("First occurrence: " + arrayList.indexOf(elementToFind));
                    System.out.println("Last occurrence: " + arrayList.lastIndexOf(elementToFind));
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
