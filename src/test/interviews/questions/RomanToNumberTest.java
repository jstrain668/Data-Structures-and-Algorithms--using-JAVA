package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanToNumberTest {

    RomanToNumber rtn;

    @BeforeEach
    void init(){
        rtn = new RomanToNumber();
    }

    @Test
    void romanToDecimal() {
        String str1 = "III";
        String str2 = "IV";
        String str3 = "IX";
        String str4 = "LVIII";
        String str5 = "MCMXCIV";

        assertEquals(3, rtn.romanToDecimal(str1));
        assertEquals(4, rtn.romanToDecimal(str2));
        assertEquals(9, rtn.romanToDecimal(str3));
        assertEquals(58, rtn.romanToDecimal(str4));
        assertEquals(1994,rtn.romanToDecimal(str5));
    }
}