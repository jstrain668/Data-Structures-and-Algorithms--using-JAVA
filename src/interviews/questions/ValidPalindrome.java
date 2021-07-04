package interviews.questions;

public class ValidPalindrome {

    public boolean alphaNumeric(char c){
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    //Description: Run two indexes from start and end, which checks that the char at start index and end
    //index are alphanumeric characters. The case of string is changed to lower case as case insensitive
    //requirement. If character is not alphanumeric skip to the next character to be processed otherwise
    //check character at respective indexes match. If not a match return false otherwise continue processing
    //incrementing and decrementing respective indexes. If we reach end of while loop then string is a
    //palindrome as characters match.
    //Time Complexity: O(n) as each character is only visited once.
    //Space Complexity: O(1)
    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0){
            throw new IllegalArgumentException("Null or empty string passed");
        }

        if (s.length() == 1){
            return true;
        }

        s = s.toLowerCase();
        int startIndex = 0;
        int endIndex = s.length()-1;

        while (startIndex <= endIndex){

            if (startIndex <= endIndex && !alphaNumeric(s.charAt(startIndex))){
                startIndex++;
                continue;
            }

            if (startIndex <= endIndex && !alphaNumeric(s.charAt(endIndex))){
                endIndex--;
                continue;
            }

            if (s.charAt(startIndex) != s.charAt(endIndex)){
                return false;
            }

            startIndex++;
            endIndex--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String str = "A man, a plan, a canal: Panama";
        System.out.println("Source string: "+str);
        System.out.println("String is a valid palindrome: "+vp.isPalindrome(str));
    }
}
