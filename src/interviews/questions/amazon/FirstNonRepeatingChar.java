package interviews.questions.amazon;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//Question:Find first non-repeated character in a string. Eg. AAABBBC, Returns C.
//public Character nonRepeatedCharacter(final String input) {
//}
//https://leetcode.com/problems/first-unique-character-in-a-string/

//Reference: https://javahungry.blogspot.com/2013/12/first-non-repeated-character-in-string-java-program-code-example.html
//Reference: https://stackoverflow.com/questions/35151126/find-the-first-non-repeating-character-in-a-string/35151695

public class FirstNonRepeatingChar {


    //Solution: Store each char in a LinkedHasMap along with its associated frequency (char count). Since linked hash
    //map maintains insertion order, iterating over the linkedhashmap checking for frequency of the first occurrence
    //of char count = 1.
    //Time Complexity: O(n) for creating the linkedHashmap and potentially O(n) for iterating over the map. Overall
    //runtime is O(2n) = O(n)
    //Space Complexity: O(n) for LinkedHashMap
    public Character firstNonRepeatChar(String s){
        Map<Character,Integer> map = new LinkedHashMap<>();

        if (s == null || s.isEmpty()){
            return null;
        }

        for (int i=0; i < s.length(); i++){
            char ch = s.charAt(i);

            if (map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            } else{
                map.put(ch,1);
            }
        }

        for (Map.Entry<Character,Integer> entry: map.entrySet()){

            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return null;
    }

    //Solution: If positions returned by the indexOf() and lastIndexOf() methods of the specified character are the same,
    //then that character is the first non-repeated character in a string.
    //Time Complexity: O(n) for traversing the string as a sequence of characters. indexOf and lastIndexOf are both
    //O(m*n) where m is the length of the the pattern to match in this one character so O(n). Overall time complexity
    //O(n*(n+n)) O(2n to the power of 2)
    public Character firstNonRepeat(String s){

        if (s == null || s.isEmpty()){
            return null;
        }

        for (int i=0; i < s.length();i++){
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                return s.charAt(i);
            }
        }
        return null;
    }

    //HasMap to store the frequency count of each unique character in the string. Iterate over the string to find the
    //first occurrence of a character in the map with frequency count of 1.
    //Time Complexity: O(2n) which comes to O(n)
    //Space Complexity: O(n) or O(26) or O(256) depending the scope of the character definition.
    public Character firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<>();
        // build hash map : character and how often it appears

        for (int i=0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (count.containsKey(ch)){
                count.put(ch,count.get(ch)+1);
            } else {
                count.put(ch, 1);
            }
        }

        // find the index
        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1)
                return s.charAt(i);
        }
        return null;
    }

    public static void main(String[] args) {
        FirstNonRepeatingChar firstUniqueChar = new FirstNonRepeatingChar();
        String s = "geekforsgeeks";

        System.out.println("Input string: "+s);
        System.out.println("First non-repeating unique character: "+firstUniqueChar.firstNonRepeatChar(s));
        System.out.println("First non-repeating unique character using lastIndexOf: "+firstUniqueChar.firstNonRepeat(s));
        System.out.println("First non-repeating unique character using lastIndexOf: "+firstUniqueChar.firstUniqChar(s));
    }
}
