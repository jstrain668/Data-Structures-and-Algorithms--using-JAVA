package interviews.questions;

import java.util.Arrays;

public class ReverseArray {

    //Description: Swap first half of the array with the second half. Utilize another array index starting
    //from end of array which is decremented for every for loop iteration. Swap first with last, second
    //with second last and so until mid point is reached.
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public void reverseArray(int[] nums) {

        for (int i=0; i < nums.length/2; i++){
            int endIndex = nums.length - i -1;
            int temp = nums[i];
            nums[i] = nums[endIndex];
            nums[endIndex] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseArray ra = new ReverseArray();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        System.out.println("Ints array : "+ Arrays.toString(nums));
        ra.reverseArray(nums);
        System.out.println("Reverse array : "+ Arrays.toString(nums));
    }

}
