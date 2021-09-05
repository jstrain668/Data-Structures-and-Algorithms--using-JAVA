package interviews.questions.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Question: Given array of integers, and an integer value X, write a function that returns true if 2 elements sum to X

public class Sum2X {

    //Solution: Get the difference between target value and current element value. Check if the difference value exists
    //in the hash set, if yes then found the current value plus difference which adds to the target value, return true.
    //Otherwise add the current element value to the hashset. Repeat until difference value found in hashset or end of
    //array is reached and return false.
    //Time Complexity: O(n) for traversing the int array
    //Space Complexity: O(n) for the HashSet
    public boolean isSum2X(int[] nums,int X){

        if (nums == null || nums.length < 2){
            return false;
        }

        Set<Integer> set = new HashSet<>();

        for (int i=0; i < nums.length; i++){

            int difference = X - nums[i];

            if (set.contains(difference)){
                System.out.println(difference+ " + "+nums[i]+" = "+X);
                return true;
            } else{
                set.add(nums[i]);
            }
        }

        return false;

    }

    public static void main(String[] args) {
        Sum2X ts = new Sum2X();
        int[] nums1 = {2,3,5,4,7};
        int[] nums2 = {2, 3, 4, -3, 0, 4, -1, 5};
        int[] nums3 = {4, 5, -1};
        int[] nums4 = {2, 3, 3};
        int X = -1;
        System.out.println("Source array: "+ Arrays.toString(nums2)+ " and target value: "+X);
        System.out.println("Output array has a pair of numbers summing to "+X +" is "+ts.isSum2X(nums2,X));

    }
}
