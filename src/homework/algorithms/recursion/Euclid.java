package homework.algorithms.recursion;

/*

https://introcs.cs.princeton.edu/java/23recursion/

 */

public class Euclid {

    public int gcd(int p, int q){
        if (q == 0)
            return p;
        else
            return gcd(q, p % q);
    }

    public static void main(String[] args) {
        Euclid euclid = new Euclid();
        int p = 102;
        int q = 68;
        int d  = euclid.gcd(p, q);
        System.out.println("gcd(" + p + ", " + q + ") = " + d);
    }
}
