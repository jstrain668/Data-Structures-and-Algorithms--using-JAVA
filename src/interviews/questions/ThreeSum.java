package interviews.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Reference: https://leetcode.com/problems/3sum/

public class ThreeSum {

    //Description: Iterate through all combinations of 3 numbers from the input array and check if their
    // sum is equal to 0.To enforce the no duplicates requirement we should not consider the same value
    // multiple times for the same position in the triplet.
    // One solution to this problem is to just add all triplets to the hashset, thus eliminating all the
    // duplicates. But there is a simpler solution: sort the array and on every loop skip all values
    // equal to value that has already been processed in the previous iteration.
    // Time Complexity: O(nlogn) + O(n power of 3) = O(n power of 3)
    // Space Complexity: O(x triplets(3)) = O(x)
    public List<List<Integer>> bfThreeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> outputs = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();

        if (nums.length < 3 || nums == null){
            return outputs;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                for (int k = j + 1; k < nums.length; k++) {

                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        System.out.println("Triplet is " + nums[i] + ", " + nums[j] + ", " + nums[k]);
                        //output.add(nums[i]);
                        //output.add(nums[j]);
                        //output.add(nums[k]);
                        //outputs.add(output);
                        outputs.add(List.of(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return outputs;
    }

    // We are looking for triplets such that a + b + c = 0.
    //Let's fix single number x as a and rearrange the equation:
    //x + b + c = 0
    //b + c = -x
    //Reduce the original problem to finding such b and c that add up to -x in O(n).
    //For this solution to work we need to sort the array at first, then create 2 pointers,
    // left and right, to the first and last element of the array respectively.
    // While the left pointer is less then right we compute the sum of values kept at pointers.
    // There are three possibilities how sum compares to -x:
    // sum < -x, we shift the left pointer to the right, because we want to increase the sum
    // sum > -x, we shift the right pointer to the left, because we want to decrease the sum
    // sum = -x, we found one of the solutions! We store triplet a, b, c it in the result variable,
    // and shift the left pointer to the right
    // But there is a question we need to answer: couldn't we miss some pairs?
    //We will prove it by contradiction for the left pointer (the proof for the right pointer is the
    //same). Let's assume that we moved the left pointer multiple times (from position left0 to leftn) and then
    // moved right pointer once (from position right0 to right1) and there is a pair that we skipped.
    //For each of the steps i (0 < i < n) condition lefti + right0 < -x was true, because left pointer
    // was shifted to the right. We also know that right1 < right0. If we combine this inequalities we
    // have  lefti + right1 < lefti + right0 < -x meaning that our assumption was incorrect and there
    // is no such lefti and right1 that will give -x in sum.
    // Time Complexity: O(n log(n) + O(n power of 2)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums.length < 3 || nums == null){
            return result;
        }

        Arrays.sort(nums);

        for (int firstIdx = 0; firstIdx < nums.length - 2; ++firstIdx) {
            if (firstIdx > 0 && nums[firstIdx] == nums[firstIdx - 1]) {
                continue;
            }

            int secondIdx = firstIdx + 1;
            int thirdIdx = nums.length - 1;

            int requiredSum = 0 - nums[firstIdx];

            while (secondIdx < thirdIdx) {
                int currentSum = nums[secondIdx] + nums[thirdIdx];

                if (currentSum < requiredSum) {
                    ++secondIdx;
                } else if (currentSum > requiredSum) {
                    --thirdIdx;
                } else {
                    result.add(List.of(nums[firstIdx], nums[secondIdx], nums[thirdIdx]));
                    ++secondIdx;
                    while (secondIdx < thirdIdx && nums[secondIdx] == nums[secondIdx - 1]) {
                        ++secondIdx;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        //List<List<Integer>> outputs = ts.bfThreeSum(nums);
        List<List<Integer>> outputs = ts.threeSum(nums);

        for (int i=0; i < outputs.size(); i++){
            List<Integer> output = outputs.get(i);
            System.out.println("Array "+i+" = "+output.toString());
        }
    }
}
