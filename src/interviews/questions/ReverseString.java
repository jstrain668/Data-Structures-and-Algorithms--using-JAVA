package interviews.questions;

public class ReverseString {

    //Description: Swap from respective ends of the string. Increment counter from start pos and
    // decrement from end pos, swapping again until counters are equal.
    // Time Complexity O(n/2) = O(n)
    // Space Complexity O(n)

    public String reverseString(String str){

        if (str == null || str.isEmpty() || (str.length()==1)){
            return str;
        }

        int incCounter = 0;
        int decCounter = str.length()-1; // Arrays start from zero to length - 1
        char[] charArray = new char[str.length()];

        while (incCounter <= decCounter){
            char temp = str.charAt(incCounter);
            charArray[incCounter] = str.charAt(decCounter);
            charArray[decCounter] = temp;
            incCounter++;
            decCounter--;
        }

        return String.valueOf(charArray);
    }

    //Description: Swap from respective ends of the string. Increment counter from start pos and
    // decrement from end pos, swapping again until counters are equal.
    // Time Complexity O(n/2) = O(n)
    // Space Complexity O(n)
    public String reverseStringForLoop(String str){

        if (str == null || str.isEmpty() || (str.length()==1))
            return str;

        char[] charArray = new char[str.length()];
        int decCounter = str.length()-1;

        for (int i=0; i <= str.length()/2; i++){
            char temp = str.charAt(i);
            charArray[i] = str.charAt(decCounter);
            charArray[decCounter] = temp;
            decCounter--;
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        String strToBeReversed = "Reverse";
        System.out.println("Original string: "+strToBeReversed);
        System.out.println("Reversed string: "+rs.reverseStringForLoop(strToBeReversed));
    }
}
