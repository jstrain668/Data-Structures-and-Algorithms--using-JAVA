package homework.algorithms.searching;

public class LinearSearch {

    public String linearSearch(int[] arr, int key){

        if (arr.length == 0)
            return "Cannot search an empty array";

        for (int i=0; i < arr.length-1; i++){
            if (arr[i] == key)
                return "Found "+key+" in array";
        }

        return key+" not found in array";
    }
    public static void main(String[] args) {
        LinearSearch ls = new LinearSearch();

        int[] arr = {12, 45, 69, 78, 89, 54};
        //int[] arr = {};

        String answer = ls.linearSearch(arr, 68);
        System.out.println(answer);
    }
}
