package interviews.questions.amazon;

import java.util.HashSet;
import java.util.Set;


//Amazon Question: Remove duplicates Write a function/method to remove all duplicate characters from a String, returning
// a String with the original characters in order.

public class RemoveDuplicates {


    //To remove duplicates build a string with only the characters added to the HashSet. Duplicates are not added to
    //HashSet and the order of the string is maintained by appending to stringbuilder every time a distinct char is
    //added in sequence
    //Time Complexity: O(n) - length of string
    //Space Complexity: O(n) for the HashSet

    public String removeDuplicates(String s){

        if(s == null || s.length() == 0 || s.length() == 1){
            return s;
        }

        Set<Character> hSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i < s.length(); i++){
            char ch = s.charAt(i);

            if (!hSet.contains(ch)){
                hSet.add(ch);
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        String s = "characters";

        System.out.println("String "+s+" with duplicate characters removed: "+rd.removeDuplicates(s));
    }
}
