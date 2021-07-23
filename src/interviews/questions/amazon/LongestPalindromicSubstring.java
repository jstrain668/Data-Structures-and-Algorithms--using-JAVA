package interviews.questions.amazon;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;

public class LongestPalindromicSubstring {

    //Dynamic Programming
    //Maintain a boolean table[n][n] that is filled in bottom up manner.
    //The value of table[i][j] is true, if the substring is palindrome, otherwise false.
    //To calculate table[i][j], check the value of table[i+1][j-1], if the value is true and str[i] is same as str[j], then we make table[i][j] true.
    //Otherwise, the value of table[i][j] is made false.
    //We have to fill table previously for substring of length = 1 and length =2 because
    //as we are finding , if table[i+1][j-1] is true or false , so in case of
    //(i) length == 1 , lets say i=2 , j=2 and i+1,j-1 doesn’t lies between [i , j]
    //(ii) length == 2 ,lets say i=2 , j=3 and i+1,j-1 again doesn’t lies between [i , j].
    // Time complexity: O(n^2). Two nested traversals are needed.
    // Auxiliary Space: O(n^2). Matrix of size n*n is needed to store the dp array.
    public int longestPalindrome(String s) {

        int n = s.length();
        int startIndex = 0;
        int maxLength = 1;

        // table[i][j] will be false if
        // substring str[i..j] is not palindrome.
        // Else table[i][j] will be true
        boolean[][] P = new boolean[n][n];

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            P[i][i] = true;
        }

        // check for sub-string of length 2.
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                P[i][i+1] = true;
                startIndex = i;
                maxLength = 2;
            }
        }

        for (int l = 3; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && P[i+1][j-1]) {
                    P[i][j] = true;

                    if (l > maxLength) {
                        maxLength = l;
                        startIndex = i;
                    }
                }
            }
        }
        System.out.println( s.substring(startIndex, startIndex + maxLength));

        return maxLength;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        List<String> string_list = Arrays.asList("ABC", "ABA","AAAAAAAAXABCDDCBA", "TRSXYZZYXPOR",
                "GAMEOFTHRONESALGOTREERTOGLAWHY", "GOKAYAKING", "babad","cbbd","a","ab");
        for (String str : string_list) {
            System.out.println("\nString : " + str);
            System.out.println("Longest Palindromic Substring: " +lps.longestPalindrome(str));
        }
    }
}
