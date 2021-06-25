package interviews.questions;

import BigO.example.MaximumSubArray;

import java.util.Arrays;

public class MaxSubArray {

    //Description: Brute force approach of finding the max sub array. The max value will be the value of the first element in
    //the array. An iteration total is recorded for summing up all the values from the index to the end of the array. As each
    // iteration is processed the iteration total is calculated and compared against the maxTotal. If iteration total great than
    //maxTotal then maxTotal is set to iteration total. This process continues until all iteration totals are processed.
    //Time Complexity: O(n x (n-1))
    //Space Complexity: O(1)
    public int bfMaxSubArray(int[] nums){

        if (nums == null || nums.length == 0){
            throw new IllegalArgumentException("Null or empty array not allowed");
        }

        int startIndex = 0;
        int endIndex = 0;
        int maxTotal = nums[0];
        for (int i=0; i < nums.length; i++){
            //Iteration total initialised to the ith element value in the array
            int iterationTotal = nums[i];
            for (int j=i+1; j < nums.length; j++){
                iterationTotal += nums[j];
                if (iterationTotal > maxTotal){
                    maxTotal = iterationTotal;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }

        int[] maxSubArray = Arrays.copyOfRange(nums,startIndex,endIndex+1);
        System.out.println("Maximum sub array: "+Arrays.toString(maxSubArray));
        return maxTotal;
    }

    //Description: Single pass solution where an iteration total (maxEndingHere) accumulates values in array and check
    // if its greater than maxSoFar and updates accordingly. If the maxEndingHere is a negative figure after its calculation
    // it is reset to zero to reset the accumulation of remaining values in the array.
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int maxSubArray(int[] nums){

        if (nums == null || nums.length == 0){
            throw new IllegalArgumentException("Null or empty array not allowed");
        }

        //Initialise variables
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        int s = 0;

        for (int i=0; i < nums.length; i++){

            maxEndingHere += nums[i];

            if (maxEndingHere > maxSoFar){
                maxSoFar = maxEndingHere;
                endIndex = i;
                startIndex = s;
            }

            if (maxEndingHere < 0){
                maxEndingHere = 0;
                s = i + 1;
            }
        }

        int[] subArray = Arrays.copyOfRange(nums,startIndex,endIndex+1);
        System.out.println("Max sub array: "+Arrays.toString(subArray));

        return maxSoFar;
    }

    public static void main(String[] args) {

        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums1 = {1};
        int[] nums2 = {5,4,-1,7,8};
        int[] nums3 = {-1,-1,-2,-2};
        System.out.println("Source array: "+Arrays.toString(nums3));
        int maxSum = maxSubArray.bfMaxSubArray(nums3);
        //long maxSum = maxSubArray.maxSubArraySinglePass(nums);
        System.out.println("Largest value using bf: "+maxSum);
        System.out.println("Largest value using single pass: "+maxSubArray.maxSubArray(nums3));
    }
}
