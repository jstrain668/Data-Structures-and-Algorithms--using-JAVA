package homework.algorithms.recursion;

/*

The function takes the first character of a String - str.charAt(0) - puts it at the end and
then calls itself - reverse() - on the remainder - str.substring(1), adding these two things
together to get its result - reverse(str.substring(1)) + str.charAt(0)

When the passed in String is one character or less and so there will be no remainder left
- when str.length()  <= 1) - it stops calling itself recursively and just returns the String passed in.

So it runs as follows:

reverse("Hello")
(reverse("ello")) + "H"
((reverse("llo")) + "e") + "H"
(((reverse("lo")) + "l") + "e") + "H"
((((reverse("o")) + "l") + "l") + "e") + "H"
(((("o") + "l") + "l") + "e") + "H"
"olleH"

 */


public class ReverseString {

    public String reverseString(String str){

        if (str == null || str.isEmpty()){
            return str;
        }

        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {

        ReverseString reverseString = new ReverseString();
        String myStr = "Guru99";

        //create Method and pass and input parameter string
        String reversed = reverseString.reverseString(myStr);
        System.out.println("The reversed string is: " + reversed);

    }
}
