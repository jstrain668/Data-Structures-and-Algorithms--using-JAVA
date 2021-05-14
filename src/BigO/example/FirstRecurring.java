package BigO.example;

import java.util.HashSet;


public class FirstRecurring {

    public static void main(String[] args) {
        //int[] arr = {2, 5, 5, 2, 3, 5, 1, 2, 4};
        int[] arr = {2,1,1,2,3,5,1,2,4}; //It should return 1
        //int[] arr = {2,3,4,5}; //It should return null
        //int[] arr = {2,5,5,2,3,5,1,2,4}; //return 5 because the pairs are before 2,2
        FirstRecurring obj = new FirstRecurring();

        if (obj != null)
            System.out.println(obj.firstRecurringElement(arr));
        else
            System.out.println("No recurring element found in array");
    }

    private Integer firstRecurringElementBruteForce(int[] array){

        //Time Complexity = O(i*j)
        //Space Complexity = O(i)
        for (int i=1; i < array.length; i++) {
            for (int j=i-1; j >= 0; j--) {
                if (array[i] == array[j])
                    return array[i];
            }
        }
        return null;
    }

    private Integer firstRecurringElement(int[] array){
        HashSet<Integer> set = new HashSet<>();

        //Space complexity O(i)
        //Time complexity O(i+i)
        for (int i : array) {
            if (set.contains(i))
                return i;
            else
                set.add(i);
        }

        return null;
    }
}
