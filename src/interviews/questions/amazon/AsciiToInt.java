package interviews.questions.amazon;

public class AsciiToInt {

    public int atoi(String number){

        if (number == null || number.length() ==0){
            throw new IllegalArgumentException("Cannot pass null or empty string");
        }
        int numericValue = 0;

        try{
            numericValue = Integer.parseInt(number);
        } catch (NumberFormatException nfe){
            return -1;
        }
        return numericValue;
    }

    public int atoi2(String number){

        if (number == null || number.length() ==0){
            throw new IllegalArgumentException("Cannot pass null or empty string");
        }
        number = number.trim();
        int numericValue = 0;
        int sign = 1;
        int startIndex = 0;

        if (number.charAt(0) == '-'){
            sign = -1;
            startIndex = 1;
        } else if (number.charAt(0) == '+'){
            sign = 1;
            startIndex = 1;
        }

        for (int i = startIndex; i < number.length(); i++){

            if (number.charAt(i) == ' '){
                continue;
            } else {
                char ch = number.charAt(i);
                if (!Character.isDigit(ch)) {
                    return -1;
                } else {
                    numericValue = numericValue * 10 + (ch - '0');
                }
            }
        }
        return numericValue * sign;
    }

    public static void main(String[] args) {
        AsciiToInt asciiToInt = new AsciiToInt();
        String number = "- 12  34";
        System.out.println("Number string :"+number+" as int: "+asciiToInt.atoi2(number));
    }
}
