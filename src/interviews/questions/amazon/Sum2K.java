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

    public boolean isSum3K(int[] nums, int k){

        if (nums == null || nums.length < 3){
            return false;
        }

        //Fix each nums[i] to find a candidate that sums to K
        for (int i=0; i < nums.length; i++){
            int difference = k - nums[i];
            Set<Integer> existingNums = new HashSet<>();
            for (int j=i; j < nums.length; j++) {

                if (existingNums.contains(difference - nums[j])) {
                    int value = difference - nums[j];
                    System.out.println(nums[i] + " plus " + nums[j] + " plus " + value + " sum to " + k);
                    return true;
                } else {
                    existingNums.add(nums[j]);
                }
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

        int[] nums6 = {12, 3, 4, 1, 6, 9};
        k = 24;
        System.out.println("Source array: "+ Arrays.toString(nums6)+ " and target value: "+k);
        System.out.println("Output array has a pair of numbers summing to "+k +" is "+ts.isSum3K(nums6,k));
    }
}
