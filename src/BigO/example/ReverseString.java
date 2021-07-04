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
        System.out.println("Reversed string using char Array from tail: "+reverseString.reverseStringFromTail(stringToReverse));
        stopWatch.stop();
        System.out.println("String reversed in "+stopWatch.getNanoTime()+" nano seconds");
        stopWatch.reset();

        stopWatch.start();
        System.out.println("Reversed string using char Array from head: "+reverseString.reverseStringFromHead(stringToReverse));
        stopWatch.stop();
        System.out.println("String reversed in "+stopWatch.getNanoTime()+" nano seconds");
        stopWatch.reset();

        stopWatch.start();
        System.out.println("Reversed string using String: "+reverseString.reverseString(stringToReverse));
        stopWatch.stop();
        System.out.println("String reversed in "+stopWatch.getNanoTime()+" nano seconds");
        stopWatch.reset();

        stopWatch.start();
        System.out.println("Reversed string using StringBuilder: "+reverseString.reverseStringBuilder(stringToReverse));
        stopWatch.stop();
        System.out.println("String reversed in "+stopWatch.getNanoTime()+" nano seconds");
        stopWatch.reset();

        stopWatch.start();
        System.out.println("Reversed string using no loop StringBuilder :"+reverseString.reverseStringBuilderNoLoop(stringToReverse));
        stopWatch.stop();
        System.out.println("String reversed in "+stopWatch.getNanoTime()+" nano seconds");
        stopWatch.reset();

        stopWatch.start();
        System.out.println("Reversed string using Stack :"+reverseString.reverseStringStack(stringToReverse));
        stopWatch.stop();
        System.out.println("String reversed in "+stopWatch.getNanoTime()+" nano seconds");
        stopWatch.reset();

        stopWatch.start();
        System.out.println("Reversed string using Stack :"+reverseString.reverseStr(stringToReverse));
        stopWatch.stop();
        System.out.println("String reversed in "+stopWatch.getNanoTime()+" nano seconds");
        stopWatch.reset();
    }

    private String reverseStr(String str){

        char[] charArray = str.toCharArray();

        for (int i=0; i < charArray.length/2; i++){
            int endIndex = charArray.length - i -1;
            char temp = charArray[i];
            charArray[i] = charArray[endIndex];
            charArray[endIndex] = temp;
        }
        return String.valueOf(charArray);
    }

    private String reverseStringFromTail(String stringToReverse) {

        char[] reversedCharArray = new char[stringToReverse.length()];
        int charArrayIndex = 0;

        if (stringToReverse == null || stringToReverse.length() == 0)
            return "";

        if (stringToReverse.length() == 1)
            return stringToReverse;

        // Start at tail and traverse to head
        // Time complexity O(n)
        for (int i=stringToReverse.length()-1; i >= 0; i--){
            reversedCharArray[charArrayIndex] = stringToReverse.charAt(i);
            charArrayIndex++;
        }

        return String.valueOf(reversedCharArray);
    }

    private String reverseStringFromHead(String stringToReverse) {

        char[] reversedCharArray = new char[stringToReverse.length()];
        int charArrayIndex = stringToReverse.length()-1;

        if (stringToReverse == null || stringToReverse.length() == 0)
            return "";

        if (stringToReverse.length() == 1)
            return stringToReverse;

        // Start at head and traverse to tail
        // Time complexity O(n)
        for (int i=0; i < stringToReverse.length(); i++){
            reversedCharArray[charArrayIndex] = stringToReverse.charAt(i);
            charArrayIndex--;
        }

        return String.valueOf(reversedCharArray);
    }

    private String reverseString(String stringToReverse) {

        String temp = "";

        if (stringToReverse == null || stringToReverse.length() == 0)
            return "";

        // Start at tail and traverse to head
        // Append each character to String
        // Time complexity O(n)
        for (int i=stringToReverse.length()-1; i >= 0; i--){
            temp += stringToReverse.charAt(i);
        }

        return temp;
    }

    private String reverseStringBuilder(String stringToReverse) {

        StringBuilder temp = new StringBuilder();

        if (stringToReverse == null || stringToReverse.length() == 0)
            return "";

        if (stringToReverse.length() == 1)
            return stringToReverse;

        // Start at tail and traverse to head
        // Append each character to StringBuilder
        // Time complexity O(n)
        for (int i=stringToReverse.length()-1; i >= 0; i--){
            temp.append(stringToReverse.charAt(i));
        }

        return temp.toString();
    }

    private String reverseStringBuilderNoLoop(String stringToReverse){

        if (stringToReverse == null || stringToReverse.length() == 0)
            return "";

        if (stringToReverse.length() == 1)
            return stringToReverse;

        // Time complexity O(n)
        return new StringBuilder(stringToReverse).reverse().toString();
    }

    private String reverseStringStack(String stringToReverse)
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

        //Time Complexity O(2n)
        // return string object
        return new String(reverseString);
    }
}
