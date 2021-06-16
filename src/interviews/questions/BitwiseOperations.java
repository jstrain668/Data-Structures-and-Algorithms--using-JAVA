package interviews.questions;

public class BitwiseOperations {

    public int add(int x, int y){

        // Iterate till there is no carry
        while (y!=0){

            // carry now contains common
            // set bits of x and y
            int carry = x & y;

            // Sum of bits of x and
            // y where at least one
            // of the bits is not set
            x = x ^ y;

            // Carry is shifted by
            // one so that adding it
            // to x gives the required sum
            y = carry << 1;
        }
        return x;
    }

    public int subtract(int x, int y){

        // Iterate till there
        // is no carry
        while (y != 0)
        {
            // borrow contains common
            // set bits of y and unset
            // bits of x
            int borrow = (~x) & y;

            // Subtraction of bits of x
            // and y where at least one
            // of the bits is not set
            x = x ^ y;

            // Borrow is shifted by one
            // so that subtracting it from
            // x gives the required sum
            y = borrow << 1;
        }
        return x;
    }

    public static void main(String[] args) {
        BitwiseOperations bo = new BitwiseOperations();
        System.out.println("Adding two numbers using bitwise operators: "+bo.add(5,5));
        System.out.println("Subtracting two numbers using bitwise operators: "+bo.subtract(5,5));
    }
}
