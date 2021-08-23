package interviews.questions.Facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2){
            return new int[0];
        }

        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0; i < nums.length; i++){
            int difference = target - nums[i];

            if (map.containsKey(nums[i])){
                int[] res = new int[2];
                res[0] = i;
                res[1] = map.get(nums[i]);
                return res;
            } else{
                map.put(difference,i);
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println("Source array: "+Arrays.toString(nums));
        System.out.println("Indices of sources array: "+Arrays.toString(ts.twoSum(nums,target))+" which add to "+target);
    }
}
