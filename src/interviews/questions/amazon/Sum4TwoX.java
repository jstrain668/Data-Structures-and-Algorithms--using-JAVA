package interviews.questions.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Question: : Ask the candidate to code the highest version of the solution that they were able to come up with (2, 3,
// or 4 elements). The code should be logically correct, with some allowance for syntax errors because of the time
// limit and coding environment.

//Reference: https://www.geeksforgeeks.org/find-four-elements-that-sum-to-a-given-value-set-2/

public class Sum4TwoX {


    static class Pair {
        int first, second;
        public Pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }


    //Solution: Store sums of all pairs in a hash table
    //Traverse through all pairs again and search for X – (current pair sum) in the hash table.
    //If a pair is found with the required sum, then make sure that all elements are distinct array elements and an
    // element is not considered more than once.
    //Time Complexity:  O(n^2).
    //Nested traversal is needed to store all pairs in the hash Map.
    //Space Complexity:  O(n^2).
    //All n*(n-1) pairs are stored in hash Map so the space required is O(n^2)
    //Please write comments if you find any of the above codes/algorithms incorrect, or find other ways to solve the
    // same problem.
    public boolean isSum4TwoX(int[] nums, int X){

        if (nums == null || nums.length < 4){
            return false;
        }

        Map<Integer,Pair> map = new HashMap<>();

        // Store sums of all pairs in a hash table
        for (int i=0; i < nums.length -1; i++){
            for (int j=i+1; j < nums.length; j++){
                map.put(nums[i]+nums[j],new Pair(i,j));
            }
        }

        for (int i=0; i < nums.length -1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                int difference = X - sum;

                if (map.containsKey(difference)) {
                    // Making sure that all elements are
                    // distinct array elements and an
                    // element is not considered more than
                    // once.
                    Pair p = map.get(difference);
                    if (p.first != i && p.first != j
                            && p.second != i && p.second != j) {
                        System.out.println(nums[i] + ", " + nums[j] + ", "
                                + nums[p.first] + ", "
                                + nums[p.second]+ " sum to "+X);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Sum4TwoX ts = new Sum4TwoX();
        int[] nums1 = {2,3,5,4,7};
        int[] nums2 = {2, 3, 4, -3, 0, 4, -1, 5};

        int[] nums4 = {2, 3, 3};
        int X = 15;

        System.out.println("Source array: "+ Arrays.toString(nums1)+ " and target value: "+X);
        System.out.println("Output array has a pair of numbers summing to "+X +" is "+ts.isSum4TwoX(nums1,X));

    }
}
