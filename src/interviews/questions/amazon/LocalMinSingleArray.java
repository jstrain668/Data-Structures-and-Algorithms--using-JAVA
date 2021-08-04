package interviews.questions.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Question: Problem: Given an array A[0,…, n-1], an element at index i(0 < i < n-1) is a local minimum if A[i] < A[i-1]
// as well as A[i]< A[i+1]. That is, the element is lower than the element to the immediate left as well as to the
// element to the immediate right.
// Constraints: – The arrays has at least three elements–
// The first two numbers are decreasing and the last two numbers are increasing.
// – The numbers are unique
public class LocalMinSingleArray {


    //Solution: Linear for loop executing comparisons to find local min which satisfies a[i] < a[i-1] and a[i] < a[i+1]
    //This for loop requires 3 elements to work. Before the loop handle the special cases of empty (throw exception) and
    // less than 3 elements in the array. return -1
    //Time Complexity: O(n)
    //Space Complexity: O(1)

    public int findLocalMinLinear(int[] nums){

        if (nums == null || nums.length == 0){
            System.out.println("Null or empty array passed into findLocalMin");
            return -1;
        }

        if (nums.length > 0 && nums.length < 3){
            System.out.println("Size of array passed into findLocalMin "+nums.length+ " is less than min array length 3");
            return -1;
        }

        //Start from 1 to handle predecessor check and end before length -1 to handle successor check
        for (int i=1; i < nums.length-1; i++){

            // nums[i] has to be less than its left neighbour and right neighbour
            if ((nums[i] < nums[i-1]) && (nums[i] < nums[i+1])) {
                return nums[i];
            }
        }

        //Reached here then a local min couldn't be found
        System.out.println("No local min could be found");
        return -1;
    }

    public int findLocalMinIterative(int[] nums){

        if (nums == null || nums.length == 0){
            System.out.println("Null or empty array passed into findLocalMin");
            return -1;
        }

        if (nums.length > 0 && nums.length < 3){
            System.out.println("Size of array passed into findLocalMin "+nums.length+ " is less than min array length 3");
            return -1;
        }

        int start = 0;
        int end = nums.length;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (mid == 0 || mid == nums.length-1){
                System.out.println("No local min could be found - mid point reached "+mid);
                return -1;
            }

            if ((nums[mid] < nums[mid-1]) && (nums[mid] < nums[mid+1])) {
                return nums[mid];
            }
            else if (nums[mid] > nums[mid - 1]) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        //Reached here then a local min couldn't be found
        System.out.println("No local min could be found");
        return -1;

    }

    public int findLocalMin(int[] nums){

        if (nums == null || nums.length == 0){
            System.out.println("Null or empty array passed into findLocalMin");
            return -1;
        }

        if (nums.length > 0 && nums.length < 3){
            System.out.println("Size of array passed into findLocalMin "+nums.length+ " is less than min array length 3");
            return -1;
        }

        return findLocalMinima(nums,0,nums.length);
    }

    private int findLocalMinima(int[] nums, int start, int end)
    {
        int mid = start + (end - start) / 2;
        // Find index of middle element

        if (mid == 0 || mid == nums.length-1){
            System.out.println("No local min could be found - mid point reached "+mid);
            return -1;
        }

        if ((nums[mid] < nums[mid-1]) && (nums[mid] < nums[mid+1])) {
            return nums[mid];
        }
        else if (nums[mid] > nums[mid - 1]) {
            return findLocalMinima(nums, start, mid);
        }
        else {
            return findLocalMinima(nums, mid + 1, end);
        }
    }


    public static void main(String[] args) {

        LocalMinSingleArray localMinSingleArray = new LocalMinSingleArray();
        int[] nums = {10, 5, 3, 6, 13, 16, 19};
        int[] nums1 = {14,13,12,11};
        int[] nums2 = {11,12,13,14};
        int[] nums3 = {8,6};
        int[] nums4 = {8, 5, 2, 7, 3, 4, 1, 9};
        int[] nums5 = {3,0,-1,-2,-4,-7,-10, -12, 0, -8,10};
        System.out.println("Array of ints: "+ Arrays.toString(nums5));

        System.out.println("Local min: "+localMinSingleArray.findLocalMinLinear(nums5));
        System.out.println("Local min: "+localMinSingleArray.findLocalMinima(nums5,0,nums5.length));
        System.out.println("Local min: "+localMinSingleArray.findLocalMinIterative(nums5));
    }
}
