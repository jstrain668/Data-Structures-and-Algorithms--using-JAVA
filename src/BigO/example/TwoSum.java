package BigO.example;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    //Input: nums = [2,7,11,15], target = 9
    //Output: [0,1]
    //Output: Because nums[0] + nums[1] == 9, we return [0, 1].
    public static void main(String[] args) {
      int[] nums = new int[] {4,2,4,8};
      int target = 8;
      int[] indicies = new int[2];
      TwoSum twoSum = new TwoSum();

      indicies = twoSum.getIndiciesUsingOnePassHashMap(nums, target);

      if (indicies.length == 2)
          System.out.println("Retrieved indicies which add up to "+target+" are "+indicies[0]+ ","+indicies[1]);
      else
          System.out.println("Retrieved no indicies which add up to "+target);
    }

    // Time Complexity O(nxn)
    private int[] getIndiciesBruteForce(int[] nums, int target){

        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                if (nums[i] + nums[j] == target)
                    return new int[] {i,j};
            }
        }

        // Illegal arguments passed to the method
        throw new IllegalArgumentException("No two sum solution");
    }

    // Time Complexity O(n+n)
    private int[] getIndiciesUsingHashMap(int[] nums, int target){

        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++){
           map.put(nums[i],i);
        }

        int complement;
        for (int i=0; i<nums.length; i++){
            complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i)
                return new int[] {i,map.get(complement)};
        }

        // Illegal arguments passed to the method
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] getIndiciesUsingOnePassHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
