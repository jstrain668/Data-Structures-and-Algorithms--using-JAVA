package interviews.questions;

// Reference: https://leetcode.com/problems/reverse-integer/

public class ReverseInteger {

    //Description: To reverse the integer, repeatedly divide `n` by 10 until `n` is equal to zero. Every
    //time `n` divided by 10 use the mod operator to get last digit which is added to the reversed number
    //Reversed number is multiplied by 10 to reflect each 10's digit.
    //Used long type to record the answer and then check against overflow or underflow of MAX and MIN
    //int respectively. If overflow or underflow then return 0, otherwise cast the long to an int.
    //Time Complexity: O (log n)
    //Space Complexity: O (1)
    public int reverse(int n) {

        long res = 0;
        while (n != 0) {
            res = res * 10 + n % 10;
            n /= 10;
        }

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        int n = 123;
        System.out.println("Reverse value of "+n+" = "+ri.reverse(n));
    }


}
