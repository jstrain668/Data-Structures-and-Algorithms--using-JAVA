package BigO.example;

import java.util.Stack;

/**
 * Given an encoded string, return it's decoded string.
 *
 * <p>The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
 * is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * <p>You may assume that the input string is always valid; No extra white spaces, square brackets
 * are well-formed, etc.
 *
 * <p>Furthermore, you may assume that the original data does not contain any digits and that digits
 * are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * <p>Examples:
 *
 * <p>s = "3[a]2[bc]", return "aaabcbc". s = "3[a2[c]]", return "accaccacc". s = "2[abc]3[cd]ef",
 * return "abcabccdcdcdef".
 *
 * <p>Solution: Maintain a stack and push items when a character other than ] is encountered. When a
 * character ] is encountered pop elements, build string and duplicate it.
 */


public class DecodeString {


/**
 * Main method
 *
 * @param args
 * @throws Exception
 */
    public static void main(String[] args) throws Exception {

        DecodeString decodeString = new DecodeString();
        String str1 = "3[a]2[bc]";
        String str2 = "3[a2[c]]";
        String str3 = "2[abc]3[cd]ef";
        String output = decodeString.decodeString(str3);
        System.out.println(output);
    }

    /**
     * decodeString method
     *
     * @param s (string to be decoded)
     */

    public String decodeString(String s) {
        if (s.length() == 0 || s == null) {
            return s;
        }
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int num = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    num = num * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                numStack.push(num);
            } else if (s.charAt(idx) == '[') {
                strStack.push(res.toString());
                res = new StringBuilder();
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder temp = new
                        StringBuilder(strStack.pop());
                int repeatTimes = numStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp;
                idx++;
            } else {
                res.append(s.charAt(idx++));
            }
        }
        return res.toString();
    }
}
