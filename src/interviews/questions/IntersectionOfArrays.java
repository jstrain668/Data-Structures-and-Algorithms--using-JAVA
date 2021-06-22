package interviews.questions;

import java.util.*;

public class IntersectionOfArrays {


    public int[] listToArray(List<Integer> list){

        int[] result = new int[list.size()];

        for(int i=0; i < list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }
    //Description: To find the intersection of two arrays, sort each array so that a one loop comparison
    //can be performed. Since each array is sorted the loop counter for each array is only incremented when
    //its less than its array size and if there is a match or its value is less than value in the other array
    //Matches are added to ArrayList and then converted to an int array.
    //Time Complexity: O(n) - One loop to find matches and another loop to convert list to int array
    //Space Complexity: O(n) - For the list and the int array
    public int[] intersect(int[] nums1, int[] nums2){

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length ==0){
            return new int[0];
        }

        int i=0;
        int j=0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length){
            if (nums1[i] == nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }

        return listToArray(result);
    }

    public static void main(String[] args) {
        IntersectionOfArrays ioa = new IntersectionOfArrays();
        int[] nums1 = new int[] {1,2,2,1};
        int[] nums2 = new int[] {2,2};
        int[] nums3 = new int[] {4,9,5};
        int[] nums4 = new int[] {9,4,9,8,4};

        System.out.print("Array 1: "+ Arrays.toString(nums1)+" intersect "+Arrays.toString(nums2)+" : ");
        System.out.println(Arrays.toString(ioa.intersect(nums1,nums2)));
        System.out.print("Array 1: "+ Arrays.toString(nums3)+" intersect "+Arrays.toString(nums4)+" : ");
        System.out.println(Arrays.toString(ioa.intersect(nums3,nums4)));
    }
}
