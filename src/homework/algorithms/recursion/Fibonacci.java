package homework.algorithms.recursion;

/*

https://introcs.cs.princeton.edu/java/23recursion/

*/

public class Fibonacci {

    private long[] fn = new long[92];

    public long efficientFibonacci(int n){

        if (n <= 1)
            return n;

        if (fn[n] > 0)
            return fn[n];

        fn[n] = efficientFibonacci(n-1) + efficientFibonacci(n-2);
        return fn[n];

    }

    public long inefficientFibonacci(int n){
        if (n <= 1)
            return n;
        else
            return inefficientFibonacci(n-1) + inefficientFibonacci(n-2);
    }

    public static void main(String[] args) {

        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.inefficientFibonacci(8));
        System.out.println(fibonacci.efficientFibonacci(8));
    }

}
