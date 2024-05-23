
import java.util.Arrays;

 class ArrayOperations {
    // Method to initialize an array with given elements
    public static int[] initializeArray(int[] elements) {
        return elements;
    }

    // Method to find the sum of all elements in the array
    public static int findSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    // Method to find the maximum element in the array
    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Method to find the minimum element in the array
    public static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // Method to sort the elements of the array in ascending order
    public static int[] sortArray(int[] array) {
        Arrays.sort(array);
        return array;
    }

    // Method to reverse the elements of the array
    public static int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = 0, j = array.length - 1; i < array.length; i++, j--) {
            reversedArray[i] = array[j];
        }
        return reversedArray;
    }

    public static void main(String[] args) {
        int[] elements = {5, 8, 2, 10, 3};

        // A. Initialize an array with given elements
        int[] array = initializeArray(elements);

        // B. Find the sum of all elements in the array
        int sum = findSum(array);
        System.out.println("Sum of all elements: " + sum);

        // C. Find the maximum element in the array
        int max = findMax(array);
        System.out.println("Maximum element: " + max);

        // D. Find the minimum element in the array
        int min = findMin(array);
        System.out.println("Minimum element: " + min);

        // E. Sort the elements of the array in ascending order
        int[] sortedArray = sortArray(array);
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));

        // F. Reverse the elements of the array
        int[] reversedArray = reverseArray(array);
        System.out.println("Reversed array: " + Arrays.toString(reversedArray));
    }
}
