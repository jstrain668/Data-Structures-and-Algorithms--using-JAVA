package homework.algorithms.recursion;

/*

https://introcs.cs.princeton.edu/java/23recursion/

 */


public class Factorial {

    public long factorialRecursive(long number){

        if (number <  0)
            throw new RuntimeException("Underflow error in factorial");
        else if (number > 20)
            throw new RuntimeException("Overflow error in factorial");
        else if (number == 0)
            return 1;
        else
            return number * factorialRecursive(number-1);
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();

        System.out.println(factorial.factorialRecursive(5l));
    }
}
