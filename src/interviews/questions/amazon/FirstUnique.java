package interviews.questions.amazon;


import java.util.HashMap;
import java.util.Map;

public class FirstUnique {

    //While a succinct solution the time complexity is worse than the HashMap solution
    //Time Complexity: O(n+m) average and O(n*m) worst case attributed to the indexOf call
    //Space Complexity: O(1)
    public char firstUniqueChar(String s){

        if (s == null || s.length() == 0){
            return ' ';
        }

        for (int i=0; i < s.length(); i++){
            char c = s.charAt(i);

            if (s.indexOf(c) == s.lastIndexOf(c)){
                return c;
            }
        }

        return ' ';
    }

    // Preferred solution
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public char firstUniqueCharUsingHM(String s){

        if (s == null || s.length() == 0){
            return ' ';
        }

        Map<Character,Integer> hMap = new HashMap<>();

        for (int i=0; i < s.length(); i++){
            char c = s.charAt(i);

            if (hMap.containsKey(c)){
                int count = hMap.get(c);
                hMap.replace(c,count+1);
            } else{
                hMap.put(c,1);
            }
        }

        for (int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if (hMap.get(c) == 1){
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {

        FirstUnique fu = new FirstUnique();
        String str1 = "leetcode";
        String str2 = "loveleetcode";
        String str3 = "aabb";
        System.out.println("Input string: "+str3);
        System.out.println("First unique character: "+fu.firstUniqueCharUsingHM(str3));
        System.out.println("First unique character: "+fu.firstUniqueChar(str3));

    }
}
