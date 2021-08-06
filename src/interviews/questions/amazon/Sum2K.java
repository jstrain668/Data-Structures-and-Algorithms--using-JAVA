package interviews.questions.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Amazon Question: sum2k Given an array of integers A and integer K, return true if there is at least one pair of
// integers in A that sum up to K. Return false otherwise
//Time Complexity: O(n)
//Space Complexity: O(n) for the hashset

public class Sum2K {

    public boolean isSum2K(int[] nums, int k)
    {
        if (nums == null || nums.length < 2){
            return false;
        }

        Set<Integer> set = new HashSet<>();

        for (int i=0; i < nums.length; i++){
            int difference = k - nums[i];

            if (set.contains(difference)){
                System.out.println(nums[i]+" plus "+difference+ " sum to "+k);
                return true;
            } else{
                set.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Sum2K ts = new Sum2K();
        int[] nums1 = {2,3,5,4,7};
        int[] nums2 = {2, 3, 4, -3, 0, 4, -1, 5};
        int[] nums3 = {4, 5, -1};
        int[] nums4 = {2, 3, 3};
        int k = 6;
        System.out.println("Source array: "+ Arrays.toString(nums4)+ " and target value: "+k);
        System.out.println("Output array has a pair of numbers summing to "+k +" is "+ts.isSum2K(nums4,k));

    }
}
