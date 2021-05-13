package BigO.example;

import java.util.Arrays;

public class MaximumSubArray {

    public static void main(String[] args) {

        //Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        //Output: 6
        //Explanation: [4,-1,2,1] has the largest sum = 6.

        MaximumSubArray maxSubArray = new MaximumSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        //int[] nums = {1};
        //int[] nums = {5,4,-1,7,8};
        //long maxSum = maxSubArray.maxSubArrayBruteForce(nums);
        long maxSum = maxSubArray.maxSubArraySinglePass(nums);
        System.out.println("Largest value: "+maxSum);
    }

    private long maxSubArraySinglePass(int[] nums){
        long localMax = nums[0];
        long globalMax = nums[0];
        int startIndex=0;
        int endIndex=0;

        if (nums == null || nums.length == 0){
            throw new IllegalArgumentException("No max sub array solution");
        }

        for (int i=0; i < nums.length; i++){

            if (nums[i] > localMax + nums[i]){
                startIndex = i;
                localMax = nums[i];
            } else
                localMax += nums[i];

            if (globalMax < localMax){
                globalMax = localMax;
                endIndex = i;
            }

            System.out.println("LocalMax : "+localMax+ " and Global Max "+globalMax);
            System.out.println("StartIndex : "+startIndex+ " and EndIndex "+endIndex);
        }

        int[] subArray = Arrays.copyOfRange(nums,startIndex,endIndex+1);
        for (int j : subArray) {
            System.out.print(j + ", ");
        }

        return globalMax;
    }

    private long maxSubArrayBruteForce(int[] nums){
        long total;
        int[] subArray;
        int startIndex=0;
        int endIndex=0;

        if (nums == null || nums.length == 0){
            throw new IllegalArgumentException("No max sub array solution");
        }

        long maxValue = nums[0];
        for (int i=0; i < nums.length; i++){
            total = nums[i];
            for (int j=i+1; j < nums.length; j++) {
                total += nums[j];
                if (total > maxValue){
                    maxValue = total;
                    startIndex = i;
                    endIndex = j;
                    System.out.println("Current Maxvalue is "+maxValue+" start index "+startIndex+" end index "+endIndex);
                }
            }
        }

        subArray = Arrays.copyOfRange(nums,startIndex,endIndex+1);
        for (int j : subArray) {
            System.out.print(j + ", ");
        }

        return maxValue;
    }
}
