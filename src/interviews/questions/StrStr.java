package interviews.questions;

public class StrStr {

    //Description: Use String indexOf method to find first occurrence of need in haystack.
    //Time complexity: O(n)
    //Space Complexity: O(1)
    public int strStrIndexOf(String haystack, String needle) {

        if(needle.length()==0) {
            return 0;
        }

        return haystack.indexOf(needle);
    }

    public int strStr(String haystack, String needle) {
        int index = -1;
        if(needle.length()==0) {
            return 0;
        }

        for(int x = 0; x <= (haystack.length()-needle.length()); x++){
            if(haystack.substring(x, x+needle.length()).equals(needle)) {
                index = x;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        StrStr ss = new StrStr();
        String input = "hello";
        String needle = "ll";
        System.out.println("The string: "+needle+" is found at index: "+ss.strStrIndexOf(input,needle)+" in string: "+input);
        System.out.println("The string: "+needle+" is found at index: "+ss.strStr(input,needle)+" in string: "+input);
    }
}
