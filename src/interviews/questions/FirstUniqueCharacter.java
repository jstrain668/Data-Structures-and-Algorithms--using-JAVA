package interviews.questions;

import java.util.HashMap;

public class FirstUniqueCharacter {

    // Description: To find first unique character process the string, recording the count of each
    // character in a HasMap. Loop through the string again, returning the index of the string for the
    // first occurrence of a character in the hash map with a count of 1
    // Time Complexity: O(n+n)
    // Space Complexity: O(n)

    public int firstUniqueCharWithHashMap(String s){
        HashMap<Character,Integer> uniqueChars = new HashMap<>();

        for (int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if (uniqueChars.containsKey(c)){
                int count = uniqueChars.get(c);
                uniqueChars.replace(c,count+1);
            } else {
                uniqueChars.put(c,1);
            }
        }

        // Lookup of value in HashMap using key is O(1)
        for (int i=0; i < s.length(); i++){
            if (uniqueChars.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    //Description: Find the index of the first character which shares the same index value for
    // the first occurrence check and last occurrence check against the supplied string. Return index if
    // found otherwise -1 if none found.
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int firstUniqueChar(String s){
        for (int i=0; i < s.length(); i++){
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        FirstUniqueCharacter fuc = new FirstUniqueCharacter();
        String str1 = "leetcode";
        String str2 = "loveleetcode";
        String str3 = "aabb";
        System.out.println("Input string: "+str2);
        System.out.println("First unique character: "+fuc.firstUniqueCharWithHashMap(str2));
        System.out.println("First unique character: "+fuc.firstUniqueChar(str2));

    }
}
