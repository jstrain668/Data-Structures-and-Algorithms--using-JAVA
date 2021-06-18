package interviews.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {

    //Description: Use HashSet, to detect duplicates when adding values to the HashSet. If it
    //already contains the element already return true otherwise false.
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean containsDuplicate(int[] nums){

        if (nums==null || nums.length==0)
            throw new IllegalArgumentException("Null or empty array not allowed");

        if (nums.length == 1)
            return false;

        HashSet<Integer> hs = new HashSet<>();

        for (int i=0; i < nums.length; i++){
            int num = nums[i];
            if (hs.contains(num))
                return true;
            else
                hs.add(num);
        }

        return false;
    }

    public boolean containsDuplicateUsingHasMap(int[] nums){

        if (nums==null || nums.length==0)
            throw new IllegalArgumentException("Null or empty array not allowed");

        if (nums.length == 1)
            return false;

        HashMap<Integer,Integer> hs = new HashMap<>();

        for (int i=0; i < nums.length; i++){
            int num = nums[i];
            if (hs.containsKey(num))
                return true;
            else
                hs.put(num,1);
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] nums1 = new int[]{1,2,3,1};
        int[] nums2 = new int[]{1,2,3,4};
        System.out.println("Array: "+ Arrays.toString(nums1)+" contains duplicate: "+cd.containsDuplicate(nums1));
        System.out.println("Array: "+ Arrays.toString(nums2)+" contains duplicate: "+cd.containsDuplicate(nums2));
    }
}
