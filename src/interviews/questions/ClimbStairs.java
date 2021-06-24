package interviews.questions;

import java.util.HashMap;

public class ClimbStairs {

    //Description: Problem similar to the Fibonacci sequence. When n is i, the result is the sum of
    // i-1 and i-2. The simplest is top-down recursive solution, but the time overhead is relatively large
    // Time Complexity: O(2to the poser of n)
    //Space Complexity: O(1)
    public int climbStairs(int n){

        if (n < 1 || n > 45){
            throw new IllegalArgumentException("Invalid number passed "+n);
        }

        if (n==1 || n==2){
            return n;
        }

        int result = climbStairs(n-1) + climbStairs(n-2);

        return result;
    }

    //Description: Dynamic programming approach to solution. Alot of the calculations are repeated thus
    //use a cache to store the results of repeated calculations to speed up processing
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int climbStairsUsingCache(int n){

        if (n < 1 || n > 45){
            throw new IllegalArgumentException("Invalid number passed "+n);
        }

        if (n==1 || n==2) {
            return n;
        }

        int[] cache = new int[n];
        cache[0] = 1;
        cache[1] = 2;

        for (int i=2; i < n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n-1];
    }

    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        int n = 5;
        System.out.println("Number of possible steps to climb stairs: "+cs.climbStairs(n));
        System.out.println("Number of possible steps to climb stairs: "+cs.climbStairsUsingCache(n));
    }
}
