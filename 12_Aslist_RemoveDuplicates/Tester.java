import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Tester {
    public static void main(String[] args) {
        // Sample input array
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(10, 20, 10, 15, 40, 15, 40));
        
        // Remove duplicates and get the result
        removeDuplicates(arrayList);   
    }
    public  static void removeDuplicates(List<Integer> list) {
        Set<Integer> set = new LinkedHashSet<>(list);
         // Print the result
        System.out.println("Unique elements: " + set);
    }
}
