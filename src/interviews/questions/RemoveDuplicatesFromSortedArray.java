package interviews.questions;

import java.util.Arrays;

//Reference: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

//Note: Another poorly stated question.

public class RemoveDuplicatesFromSortedArray {

    //Description: Duplicates are not removed, but moved to the end of the array.
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int removeDuplicates(int[] nums)
    {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray rd = new RemoveDuplicatesFromSortedArray();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("Original array: "+ Arrays.toString(nums));
        System.out.println("Kth element: "+ rd.removeDuplicates(nums));
        System.out.println("Duplicates removed array: "+ Arrays.toString(nums));
    }
}
