import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class N_Main {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2, 1};
        int[] nums2 = {3, 2};
        intersection(nums1, nums2);
      
        int[] nums3 = {4, 9, 5,9};
        int[] nums4 = {9, 4, 9, 8, 4};
       intersection(nums3, nums4);
       
    }
    public static void intersection(int[] nums1, int[] nums2) {
     Set<Integer> set = new HashSet<>();
       for(int i=0;i<nums1.length;i++){
        for(int j=0;j<nums2.length;j++){
            if(nums1[i]==nums2[j]){
               set.add(nums2[j]);
            }
        }

       }
       System.out.println("Unique elements: " + set);
}

}