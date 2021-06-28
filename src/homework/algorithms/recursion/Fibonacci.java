package homework.algorithms.recursion;

/*

https://introcs.cs.princeton.edu/java/23recursion/

*/

import java.util.HashMap;

public class Fibonacci {

    private HashMap<Integer,Long> fibHM = new HashMap<>();

    // Time complexity of O(n)
    // But space complexity has now increased with usage of HashMap
    public long efficientFibonacci(int n){

        if (n == 0 || n == 1)
            return n;

        if (fibHM.containsKey(n))
            return fibHM.get(n);

        Long nthValue = efficientFibonacci(n-1) + efficientFibonacci(n-2);
        fibHM.put(n,nthValue);
        return nthValue;

    }

    // Time Complexity = O(2 to the power of n)
    public long inefficientFibonacci(int n){
        if (n <= 1)
            return n;
        else
            return inefficientFibonacci(n-1) + inefficientFibonacci(n-2);
    }

    public static void main(String[] args) {

        Fibonacci fibonacci = new Fibonacci();
        //System.out.println(fibonacci.inefficientFibonacci(100));
        System.out.println(fibonacci.efficientFibonacci(100));
    }

}
