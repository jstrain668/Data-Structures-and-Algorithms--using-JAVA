package interviews.questions;

import java.util.Arrays;

//Description: https://leetcode.com/problems/merge-sorted-array/

public class MergeSortedArray {

    //Description: Append elements from nums2 to nums1 and sort the resultant array
    //Time Complexity: O(n logn) = O(n) + O(n log n)
    //Space Complexity: O(1)
    public void simpleMerge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0){
            return;
        }

        int index = 0;
        for (int i = m; i < (m+n); i++){
            nums1[i] = nums2[index];
            index++;
        }

        Arrays.sort(nums1);
    }

    //Description: Merge into the end of nums1 array, inserting largest value from both arrays into
    //last position and continue on comparing between the source arrays and checking if m/n are less
    //than zero
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        int totalLen = m + n;
        m--;
        n--;

        for(int i = totalLen - 1; i >= 0; i--){
            if(m < 0){
                nums1[i] = nums2[n];
                n--;
            } else if (n < 0){
                nums1[i] = nums1[m];
                m--;
            } else if(nums1[m] <= nums2[n]){
                nums1[i] = nums2[n];
                n--;
            } else {
                nums1[i] = nums1[m];
                m--;
            }
        }

    }

    //Description: Starting from the end of each array, insert largest element at the end of nums1.
    //Compare both end elements from respective arrays and insert largest at end index of nums.
    //Decrement the index for overall nums1 (k) and the array which contained the largest value.
    //Repeat the same process until the i index (nums1) or j index (nums2) is is less than 0
    //If the j index is >= 0 then process the rest of nums2 from j down to 0.
    //Time complexity: O(m+n)
    //Space complexity: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1;
        int i=m-1,j=n-1;

        while (i >= 0 && j >= 0){
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >=0){
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();
        int[] nums1 = {1,2,3,0,0,0};
        //int[] nums1 = {1};
        //int[] nums1 = {0};
        int[] nums2 = {2,5,6};
        //int[] nums2 = {};
        //int[] nums2 = {1};
        System.out.println("Nums1 : "+ Arrays.toString(nums1));
        System.out.println("Nums2 : "+ Arrays.toString(nums2));
        //msa.simpleMerge(nums1, 0, nums2, nums2.length);
        msa.merge2(nums1,3,nums2,nums2.length);
        System.out.println("Nums1 : "+ Arrays.toString(nums1));

    }
}
