package interviews.questions;

import java.util.*;

//Reference: https://leetcode.com/problems/intersection-of-two-arrays-ii/

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
    //Q1: What if the given array is already sorted? How would you optimize your algorithm
    //A1: Use two pointers. At start two pointers point to the first element of each array.
    //If it is equal, push it to the answer then move both pointers to next position. Otherwise,
    //move the one with less value to the next position.
    //Q2: What if nums1's size is small compared to nums2's size? Which algorithm is better?
    //A2: The sorting solution has a bigger dominant term compared to the hashmap solution O(n1 log n1)
    // + O(n2 log n2) + O(n1 + n2) +O(r) versus O(n1) + O(n2) +O(r)
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

    //Description: Store each value in array1 in a HashMap recording the count of occurrences for each
    //key. Loop through each value in array2 looking for matches against key, and if found check the
    //occurrences count > 0. Can only match up to the number of occurrences recorded. When match found
    //store in arrayList (has to be array list as we don't know the size in advance) and decrement
    //occurrence count for that key. Last convert ArrayList to array.
    // Time Complexity: O(n1) + O(n2) + O(resultArraySize)
    // Space Complexity: O(hm) + O(al) + O(a)

    public int[] intersect2(int[] nums1, int[] nums2){

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length ==0){
            return new int[0];
        }

        HashMap<Integer,Integer> intersect = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i=0; i < nums1.length; i++){
            int key = nums1[i];
            if(intersect.containsKey(key)){
                intersect.put(key,intersect.get(key)+1);
            } else {
                intersect.put(key,1);
            }
        }

        for (int i=0; i < nums2.length; i++){
            int key = nums2[i];
            if(intersect.containsKey(key) && intersect.get(key) > 0){
                result.add(key);
                intersect.replace(key,intersect.get(key)-1);
            }
        }

        return listToArray(result);
    }

    //https://medium.com/@punitkmr/intersection-of-two-arrays-ii-ffb26f04dfd1
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
        System.out.println(Arrays.toString(ioa.intersect2(nums3,nums4)));
    }
}
