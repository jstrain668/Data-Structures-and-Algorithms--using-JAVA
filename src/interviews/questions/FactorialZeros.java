package interviews.questions;

public class FactorialZeros {

    public int bfTrailingZeroes(int n) {

        long result = 1;
        int multiplier = 1;

        while (multiplier <= n){
            result *= multiplier;
            multiplier++;
        }

        System.out.println(+n+" factorial is "+result);
        int count = 0;
        while (result%10 == 0){
            count++;
            result /= 10;
        }

        return count;
    }

    public int trailingZeroes(int n){

        int sum = 0;
        while (n >= 5) {
            n /= 5;
            sum += n;
        }
        return sum;
    }
    public static void main(String[] args) {
        FactorialZeros fz = new FactorialZeros();
        int n = 25;
        System.out.println("Number of trailing zeros in "+n+" factorial is: "+fz.bfTrailingZeroes(n));
        System.out.println("Number of trailing zeros in "+n+" factorial is: "+fz.trailingZeroes(n));
    }
}
