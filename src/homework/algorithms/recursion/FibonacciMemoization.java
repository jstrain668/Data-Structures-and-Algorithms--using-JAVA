package homework.algorithms.recursion;

public class FibonacciMemoization {
    long[] cache;

    FibonacciMemoization(long[] cache){
        this.cache = cache;
    }

    long fibonacci(int n) {

        if (cache[n] == 0) {
            if (n < 2)
                cache[n] = n;
            else
                cache[n] = fibonacci(n-1) + fibonacci( n-2);
        }

        return cache[n];
    }

    public static void main(String[] args) {
        int n = 100;
        FibonacciMemoization fm = new FibonacciMemoization(new long[n+1]);
        System.out.println(fm.fibonacci(n));
    }
}