package BigO.example;

import java.util.Hashtable;

public class LongestSubstring {

    public static void main(String[] args) {
        String input = "abcabcbb";
        //String input = "pwwkew";
        LongestSubstring obj = new LongestSubstring();

        System.out.println("Longest substring "+obj.longestSubstring(input));
    }

    private int longestSubstring(String input){
        Hashtable<Character,Integer> visited = new Hashtable<>();
        String maxSubString = "";

        for (int start=0, end=0; end < input.length(); end++){
            char currChar = (input.charAt(end));
            if (visited.containsKey(currChar)){
                start = Math.max(start,visited.get(currChar)+1);
            }

            if (maxSubString.length() < end - start + 1){
                maxSubString = input.substring(start,end +1);
            }
            visited.put(currChar,end);

            System.out.println("Start value: "+start);
            System.out.println("Current maxSubstring: "+maxSubString);
        }

        return maxSubString.length();
    }
}
