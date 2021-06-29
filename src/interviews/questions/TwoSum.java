package interviews.questions;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    // Description: Store all the unique numbers plus corresponding array index in a hashmap. To determine
    // which values add to the target value, subtract each value in the array from the target value and
    // check the difference is contained within the hashmap. If the same key value is present in the hashmap
    // also check its not the same element being added twice. This is done by comparing the index value in the
    // hashmap for the key value against the current index value of the for loop. If different then we have
    // found two values otherwise continue
    // Time Complexity O(n+n) = 2 for loops
    // Space Complexity O(n) for the Hashmap

    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Null array or array size less than 2 not allowed");
        }

        HashMap<Integer, Integer> srcMap = new HashMap<>();

        //Store the index of each unique element in the array in a hashmap
        for (int i = 0; i < nums.length; i++) {
            int keyValue = nums[i];
            if (!srcMap.containsKey(keyValue)) {
                srcMap.put(keyValue, i);
            }
        }

        // If the difference between target and the value in the array is the same as the keyValue
        // in the hashmap then we have found a pair of numbers in the array which add to the target value
        // However the match cannot be the same element twice. Check if the index value stored in the
        // hashmap is the same as the current index of the for loop. If different then we have two values
        // which add to the target.

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (srcMap.containsKey(difference) && srcMap.get(difference) != i) {
                return new int[]{srcMap.get(difference), i};
            }
        }

        //Shouldn't get to here but if we do, this array signifies no match
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums1 = {2,7,11,15};
        int[] nums2 = {3,2,4};
        int[] nums3 = {3,3};
        int target = 6;
        System.out.println("Source array: "+ Arrays.toString(nums3)+ " and target value: "+target);
        System.out.println("Target values: "+Arrays.toString(ts.twoSum(nums3,target)));
    }
}
