package BigO.example;

import java.util.Arrays;

public class MergeArrays {

    public static void main(String[] args) {

        MergeArrays mergeArrays = new MergeArrays();
        int[] sArray1 = {0,3,4,31};
        int[] sArray2 = {4,6,30};

        int[] sortedArray = mergeArrays.mergeSortedArrays(sArray1,sArray2);

        for (int j : sortedArray) {
            System.out.print(j + ", ");
        }

        System.out.println();

        int[] arrayA = new int[] {12, -7, 18, 9, 37, -1, 21};
        int[] arrayB = new int[] {27, 8, 71, -9, 18};

        sortedArray = mergeArrays.mergeUnSortedArrays(arrayA,arrayB);

        for (int j : sortedArray) {
            System.out.print(j + ", ");
        }

    }

    private int[] mergeUnSortedArrays(int[] array1, int[] array2){
        // Create an array the size of the sum of the two input arrays
        int[] mergedArray = new int[array1.length + array2.length];
        // Index position for input arrays and mergeSortedArray
        int i = 0;
        int j = 0;
        int k = 0;

        // Add array1 to mergeSortedArray
        // Time Complexity O(a)
        while (i < array1.length){
            mergedArray[k] = array1[i];
            i++;
            k++;
        }

        // Append array2 to mergeSortedArray
        // Time Complexity O(b)
        while (j < array2.length){
            mergedArray[k] = array2[j];
            j++;
            k++;
        }

        // Sort the mergedSortedArray
        // Time Complexity O(n log(n))
        Arrays.sort(mergedArray);

        // Overall time complexity O(a + b + n(log n))
        return mergedArray;
    }

    private int[] mergeSortedArrays(int[] sortedArray1, int[] sortedArray2){
        // Create an array the size of the sum of the two input arrays
        int[] mergedSortedArray = new int[sortedArray1.length + sortedArray2.length];
        // Index position for input arrays and mergeSortedArray
        int i = 0;
        int j = 0;
        int k = 0;


        while (i < sortedArray1.length && j < sortedArray2.length){

            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            if (sortedArray1[i] < sortedArray2[j]){
                mergedSortedArray[k] = sortedArray1[i];
                i++;
            } else {
                mergedSortedArray[k] = sortedArray2[j];
                j++;
            }

            k++;
        }

        // adding remaining elements of arr1 into mergedArray, if any.
        while (i < sortedArray1.length) {
            mergedSortedArray[k] = sortedArray1[i];
            i++;
            k++;
        }

        // adding remaining elements of arr2 into mergedArray, if any.
        while (j < sortedArray2.length) {
            mergedSortedArray[k] = sortedArray2[j];
            j++;
            k++;
        }

        //Time Complexity O(a + b)
        return mergedSortedArray;
    }

}