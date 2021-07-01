package interviews.questions;

import java.util.Arrays;

// Another solution would be the divide and conquer approach similar in approach to merge sort.
// First divide the arrays of string into two parts. Then we do the same for
// left part and after that for the right part. We will do it until and unless all the strings become
// of length 1. Now after that, we will start conquering by returning the common prefix of the left and
// the right strings.
// https://www.geeksforgeeks.org/longest-common-prefix-using-divide-and-conquer-algorithm/

// The recommended string search solutions are implemented as trie - a prefix tree
// that are typically used to store associative arrays where the keys are usually strings
// nodes in the tree do not store keys. Instead, they each store parts of keys. Traversing down from the
// root node to a leaf allows you to build the key as you progress. Also, there doesn't need to be a
// value at every node. In fact, values are typically only associated with leaf nodes. Building keys as
// you go is useful for specific applications, notably auto-complete.
// https://www.geeksforgeeks.org/longest-common-prefix-using-trie/
// https://leetcode.com/problems/longest-common-prefix/solution/

public class LongestCommonPrefix {

    // A Function to find the string having the minimum
    // length and returns that length
    public int findMinLength(String strs[])
    {
        int min = strs[0].length();

        for (int i = 1; i < strs.length; i++)
        {
            min = Math.min(strs[i].length(),min);
        }

        return min;
    }

    // A Function to return the index of the string with the smallest length
    public int findIndexOfMinString(String strs[])
    {
        int min = strs[0].length();
        int index = 0;

        for (int i = 1; i < strs.length; i++)
        {
            if (strs[i].length() < min){
                index = i;
            }
        }

        return index;
    }

    //Description: Check for empty array of strings and if one string supplied this is the longest
    //common prefix. Find the string with the shortest length and use this as the candidate for
    //finding a prefix common to all strings. Shortest string is the max possible length of the
    //common prefix. Cycles through all strings looking to match the shortest string against each
    //string in the array. If no match found reduce the candidate prefix size by one and repeat this
    //process until match found or prefix becomes empty string.
    //Time Complexity: O(S) , where S is the sum of all characters in all strings.
    //Space Complexity: O(n), only use constant extra space
    public String longestCommonPrefix(String[] strs) {
        int size = strs.length;

        if (size == 0){
            return "";
        }

        // Only one string, the string itself will be longest common prefix
        if (size == 1)
            return strs[0];

        //Longest possible common prefix is the smallest string in the array of strings
        int minStrIndex = findIndexOfMinString(strs);
        String prefix = strs[minStrIndex];

        //Cycle through each string, look for a match against longest possible common prefix and if not
        //found reduce prefix size by one until match found or prefix is empty
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    //Description: Check for empty array of strings and if one string supplied this is the longest common
    //prefix. Sort the strings and then find min length of all strings. The common prefix will have a
    // length equal to min length string. Execute a character match between first and last string of the
    // sorted array where bounds of search is constrained by min string length. Keep comparing until
    // character mismatch or reach the min string length.
    // Time Complexity: comparison of two strings would take at most O(MAX) where MAX is maximum number
    // of characters in any string. So the time and sorting n strings and comparing strings
    // we would need O(MAX * n * log n ) time.
    //Space Complexity: O(1)
    public String longestCommonPrefixUsingSort(String[] strs) {

        int size = strs.length;

        /* if size is 0, return empty string */
        if (size == 0)
            return "";

        // Only one string, the string itself will be longest common prefix
        if (size == 1)
            return strs[0];

        //Sort the arrays, to enable character match between first and last array
        Arrays.sort(strs);

        /* find the minimum length from first and last string */
        //int end = Math.min(strs[0].length(), strs[size-1].length());
        int minStrLen = findMinLength(strs);

        /* find the common prefix between the first and last string */
        int i = 0;
        while (i < minStrLen && strs[0].charAt(i) == strs[size-1].charAt(i) )
            i++;

        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strings = {"flower","flow","flo","flight"};
        String[] input = {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println("Source strings are: "+ Arrays.toString(strings));
        System.out.println("Source strings are: "+ Arrays.toString(input));
        System.out.println("Longest common prefix: "+ lcp.longestCommonPrefixUsingSort(strings));
        System.out.println("Longest common prefix: "+ lcp.longestCommonPrefix(strings));
    }
}
