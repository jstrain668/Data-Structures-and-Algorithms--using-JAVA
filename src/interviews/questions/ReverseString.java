package interviews.questions;

//Reference: https://leetcode.com/problems/reverse-string/

public class ReverseString {

    //Description: Swap from respective ends of the string. Increment counter from start pos and
    // decrement from end pos, swapping again until counters are equal.
    // Time Complexity O(n/2) = O(n)
    // Space Complexity O(n)
    public String reverseString(String str){

        if (str == null || str.isEmpty() || (str.length()==1))
            return str;

        char[] charArray = new char[str.length()];
        int decCounter = str.length()-1;
        int incCounter = 0;

        while (incCounter <= decCounter){
            char temp = str.charAt(incCounter);
            charArray[incCounter] = str.charAt(decCounter);
            charArray[decCounter] = temp;
            incCounter++;
            decCounter--;
        }

        return new String(charArray);
    }

    //Description: Swap from respective ends of the string. Increment counter from start pos and
    // decrement from end pos, swapping again until counters are equal.
    // Time Complexity O(n/2) = O(n)
    // Space Complexity O(1). Passed in character array is updated with no recourse to additional
    // character array
    public void reverseCharArray(char[] charArray){

        if (charArray.length ==0 || charArray.length==1)
            return;

        int incCounter = 0;
        int decCounter = charArray.length-1;

        while (incCounter < decCounter){
            char temp = charArray[incCounter];
            charArray[incCounter++] = charArray[decCounter];
            charArray[decCounter--] = temp;
        }
    }

    // https://www.java67.com/2016/06/how-to-reverse-string-in-place-in-java.html
    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        String strToBeReversed = "Reverse";
        char[] charArray = {'R','e','v','e','r','s','e'};
        //char[] charArray = strToBeReversed.toCharArray();
        System.out.println("Original string: "+strToBeReversed);
        System.out.println("Reversed string: "+rs.reverseString(strToBeReversed));
        rs.reverseCharArray(charArray);
        System.out.println("Reversed character array: "+String.valueOf(charArray));
    }
}
