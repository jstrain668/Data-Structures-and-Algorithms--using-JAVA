package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOf1BitsTest {

    NumberOf1Bits numberOf1Bits;

    @BeforeEach
    void init(){

        numberOf1Bits = new NumberOf1Bits();
    }

    @Test
    void hammingWeight() {
        assertEquals(2,numberOf1Bits.hammingWeight(3));
        assertEquals(7,numberOf1Bits.hammingWeight(799));
    }
}