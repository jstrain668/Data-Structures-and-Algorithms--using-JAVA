package examples.scenarios;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CommonElementsInArrays {

    public static void main(String[] args) {

        char[] array1 = {'a','b','c'};
        char[] array2 = {'z','y', 'i','d'};
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        if (hasCommonElement(array1,array2))
            System.out.println("Found common element in arrays");
        else
            System.out.println("No common element found in array");
        stopWatch.stop();

        System.out.println("Execution time in nano seconds for hasCommonElement: "+stopWatch.getNanoTime());
        stopWatch.reset();

        stopWatch.start();
        if (hasCommonElementInSet(array1,array2))
            System.out.println("Found common element in HashSet");
        else
            System.out.println("No common element found in HashSet");
        stopWatch.stop();

        System.out.println("Execution time in nano seconds for hasCommonElementInSet: "+stopWatch.getNanoTime());
        stopWatch.reset();

        stopWatch.start();
        if (hasCommonElementInHashMap(array1,array2))
            System.out.println("Found common element in HashMap");
        else
            System.out.println("No common element found in HashMap");
        stopWatch.stop();

        System.out.println("Execution time in nano seconds for hasCommonElementInHashMap: "+stopWatch.getNanoTime());
        stopWatch.reset();

    }

    private static boolean hasCommonElement(char[] array1, char[] array2){

        for (char characterX: array1){
            for (char characterY: array2){
                if (characterX == characterY)
                    return true;
            }
        }

        return false;
    }

    private static boolean hasCommonElementInHashMap(char[] array1, char[] array2){

        HashMap<String, Boolean> map = new HashMap<>();
        String strValue;

        for (char c : array1) {

            strValue = String.valueOf(c);
            if (!map.containsKey(strValue)) {
                map.put(strValue, true);
            }
        }

        //map.forEach((k, v) -> System.out.println((k + ":" + v)));

        for (char c : array2) {

            if (map.containsKey(String.valueOf(c))) {
                System.out.println("Found match " + c);
                return true;
            }
        }

        return false;
    }

    private static boolean hasCommonElementInSet(char[] array1, char[] array2){

        Character[] charArray1 = convertToCharacterArray(array1);
        Character[] charArray2 = convertToCharacterArray(array2);

        Set<Character> set1 = new HashSet<>(Arrays.asList(charArray1)); //Set.of(charArray1);
        Set<Character> set2 = new HashSet<>(Arrays.asList(charArray2)); //Set.of(charArray2);

        set1.retainAll(set2);

        return set1.size() > 0;
    }

    private static Character[] convertToCharacterArray(char[] cArray){

        Character[] charArray = new Character[cArray.length];

        int i = 0;
        for (char value : cArray) {
            charArray[i++] = value;
        }

        return charArray;
    }
}
