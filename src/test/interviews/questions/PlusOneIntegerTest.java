package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlusOneIntegerTest {

    PlusOneInteger poi;
    int[] digits1;
    int[] digits2;
    int[] digits3;

    @BeforeEach
    void init(){
        poi = new PlusOneInteger();
        digits1 = new int[] {1,9,9};
        digits2 = new int[] {0};
        digits3 = new int[] {4,3,2,1};
    }

    @Test
    void plusOne() {

        assertArrayEquals(new int[] {2,0,0},poi.plusOne(digits1));
        assertArrayEquals(new int[] {1},poi.plusOne(digits2));
        assertArrayEquals(new int[] {4,3,2,2},poi.plusOne(digits3));
    }
}