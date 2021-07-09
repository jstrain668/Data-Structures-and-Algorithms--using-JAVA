package interviews.questions;

import java.util.Arrays;
import java.util.HashMap;

//Reference: https://leetcode.com/problems/valid-anagram/

public class Anagram {


    //Solve this problem in O(n) time by using hashmap. Create a hashmap which record the times that the
    //characters a-Z appear in s and compare it against. If its a match all entries will be removed from
    //hashmap leaving zero size.
    // This solution requires O(n) time to create hashmap.
    // Auxillary space of O(n).
    // https://csjobinterview.wordpress.com/2012/03/21/check-if-two-strings-are-anagrams/
    public boolean isAnagramWithHashMap(String s, String t){

        if (s == null || t == null)
            throw new IllegalArgumentException("Null string passed");

        if (s.length() != t.length())
            return false;

        HashMap<Character,Integer> aMap = new HashMap<>();

        for (int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if (aMap.containsKey(c)){
                int count = aMap.get(c);
                aMap.put(c,count+1);
            } else {
                aMap.put(c,1);
            }
        }

        for (int i=0; i < t.length(); i++){
            char c = t.charAt(i);
            if (aMap.containsKey(c)){
                int count = aMap.get(c);
                if (count > 1){
                    aMap.replace(c,count-1);
                } else {
                    aMap.remove(c);
                }
            } else {
                return false;
            }
        }
        return aMap.size() == 0;
    }

    //Description: if t is an anagram of s, sorting both strings will result in two identical strings.
    //Furthermore, if s and t have different lengths, t must not be an anagram of s & can return early.
    //Time complexity : O(nlogn). Assume that n is length of s, sorting costs O(n \log n) and comparing
    // two strings costs O(n). Sorting time dominates and the overall time complexity is O(nlogn).
    //Space complexity : O(n). Space depends on the sorting implementation which, usually, costs O(1)
    // auxiliary space if heapsort is used. Note that in Java, toCharArray() makes a copy of the string
    // so it costs O(n) extra space,
    public boolean isAnagram(String s, String t){
        if (s == null || t == null)
            throw new IllegalArgumentException("Null string passed");

        if (s.length() != t.length())
            return false;

        char[] tArray = t.toCharArray();
        char[] sArray = s.toCharArray();

        Arrays.sort(tArray);
        Arrays.sort(sArray);

        return Arrays.equals(tArray,sArray);
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        String str1 = "tar";
        String str2 = "tat";
        System.out.println("Is s1: "+str1+" an anagram of "+str2+" : "+anagram.isAnagram(str1,str2));
        System.out.println("Is s1: "+str1+" an anagram of "+str2+" : "+anagram.isAnagramWithHashMap(str1,str2));
    }
}
