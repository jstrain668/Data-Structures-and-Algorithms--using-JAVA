package interviews.questions;

public class PowerOfThree {

    //Description: Solve by dividing the number n by 3 until the remainder of the division is non-zero
    //If the final remainder is 1 then the number n is a power of 3 otherwise false
    //Time Complexity: O(log n) where the base is 3
    //Space Complexity: O(1)
    public boolean isPowerOfThree(int n){
        if (n<1){
            return false;
        }

        while (n%3 == 0){
            n /= 3;
        }

        return n==1;
    }

    public static void main(String[] args) {
        PowerOfThree pot = new PowerOfThree();
        int n = 9;
        System.out.println(n+" is power of three: "+pot.isPowerOfThree(n));
    }
}
