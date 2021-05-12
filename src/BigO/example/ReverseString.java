package BigO.example;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Stack;

public class ReverseString {

    public static void main(String[] args) {

        ReverseString reverseString = new ReverseString();
        String stringToReverse = "nhoJ si eman ym iH";
        StopWatch stopWatch = new StopWatch();

        System.out.println("String to reverse : "+stringToReverse);

        stopWatch.start();
        System.out.println("Reversed string :"+reverseString.reverseStringA(stringToReverse));
        stopWatch.stop();
        System.out.println("String reversed in "+stopWatch.getNanoTime()+" nano seconds");
        stopWatch.reset();

        stopWatch.start();
        System.out.println("Reversed string :"+reverseString.reverseStringB(stringToReverse));
        stopWatch.stop();
        System.out.println("String reversed in "+stopWatch.getNanoTime()+" nano seconds");
        stopWatch.reset();

        stopWatch.start();
        System.out.println("Reversed string :"+reverseString.reverseStringC(stringToReverse));
        stopWatch.stop();
        System.out.println("String reversed in "+stopWatch.getNanoTime()+" nano seconds");
        stopWatch.reset();

        stopWatch.start();
        System.out.println("Reversed string :"+reverseString.reverseStringD(stringToReverse));
        stopWatch.stop();
        System.out.println("String reversed in "+stopWatch.getNanoTime()+" nano seconds");
        stopWatch.reset();

        stopWatch.start();
        System.out.println("Reversed string :"+reverseString.reverseStringE(stringToReverse));
        stopWatch.stop();
        System.out.println("String reversed in "+stopWatch.getNanoTime()+" nano seconds");
        stopWatch.reset();

        stopWatch.start();
        System.out.println("Reversed string :"+reverseString.reverseStringSimple(stringToReverse));
        stopWatch.stop();
        System.out.println("String reversed in "+stopWatch.getNanoTime()+" nano seconds");
        stopWatch.reset();
    }

    private static String reverseStringA(String stringToReverse) {

        char[] reversedCharArray = new char[stringToReverse.length()];
        int charArrayIndex = 0;

        if (stringToReverse == null || stringToReverse.length() == 0)
            return "";

        if (stringToReverse.length() == 1)
            return stringToReverse;

        // Last character position in stringToReverse is its length -1
        for (int i=stringToReverse.length()-1; i >= 0; i--){
            reversedCharArray[charArrayIndex] = stringToReverse.charAt(i);
            charArrayIndex++;
        }

        return String.valueOf(reversedCharArray);
    }

    private static String reverseStringB(String stringToReverse) {

        char[] reversedCharArray = new char[stringToReverse.length()];
        int charArrayIndex = stringToReverse.length()-1;

        if (stringToReverse == null || stringToReverse.length() == 0)
            return "";

        if (stringToReverse.length() == 1)
            return stringToReverse;

        for (int i=0; i < stringToReverse.length(); i++){
            reversedCharArray[charArrayIndex] = stringToReverse.charAt(i);
            charArrayIndex--;
        }

        return String.valueOf(reversedCharArray);
    }

    private static String reverseStringC(String stringToReverse) {

        StringBuilder temp = new StringBuilder();

        if (stringToReverse == null || stringToReverse.length() == 0)
            return "";

        if (stringToReverse.length() == 1)
            return stringToReverse;

        for (int i=stringToReverse.length()-1; i >= 0; i--){
            temp.append(stringToReverse.charAt(i));
        }

        return temp.toString();
    }

    private static String reverseStringD(String stringToReverse) {

        String temp = "";

        if (stringToReverse == null || stringToReverse.length() == 0)
            return "";

        for (int i=stringToReverse.length()-1; i >= 0; i--){
            temp += stringToReverse.charAt(i);
        }

        return temp;
    }

    private static String reverseStringE(String stringToReverse)
    {
        char[] reverseString = new char[stringToReverse.length()];
        // Declare a stack of type Character
        Stack<Character> stack = new Stack<Character>();

        if (stringToReverse == null || stringToReverse.length() == 0)
            return "";

        if (stringToReverse.length() == 1)
            return stringToReverse;

        // Traverse the String and push the character one by
        // one into the Stack
        for (int i = 0; i < stringToReverse.length(); i++) {
            // push the character into the Stack
            stack.push(stringToReverse.charAt(i));
        }

        // Now Pop the Characters from the stack until it
        // becomes empty

        int i = 0;
        while (!stack.isEmpty()) { // popping element until
            // stack become empty
            // get the character from the top of the stack
            reverseString[i++] = stack.pop();
        }
        // return string object
        return new String(reverseString);
    }

    private String reverseStringSimple(String stringToReverse){

        if (stringToReverse == null || stringToReverse.length() == 0)
            return "";

        if (stringToReverse.length() == 1)
            return stringToReverse;

        return new StringBuilder(stringToReverse).reverse().toString();
    }
}
