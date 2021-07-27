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
        long numericValue = 0;
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

        if ((numericValue * sign) > Integer.MAX_VALUE){
            return Integer.MIN_VALUE;
        } else if ((numericValue * sign) < Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }

        return (int) numericValue * sign;
    }

    public static void main(String[] args) {
        AsciiToInt asciiToInt = new AsciiToInt();
        String number = "123456546754";
        System.out.println("Number string :"+number+" as int: "+asciiToInt.atoi2(number));
    }
}
