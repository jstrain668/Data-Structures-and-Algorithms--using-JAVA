package interviews.questions.amazon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideNumbersTest {

    DivideNumbers dn;

    @BeforeEach
    void init(){
        dn = new DivideNumbers();
    }
    @Test
    void divide() {
        assertEquals(Integer.MAX_VALUE, dn.divide(-2147483648,-1));
        assertEquals(1073741824, dn.divide(-2147483648,-2));
        assertEquals(1073741823, dn.divide(2147483647,2));
        assertEquals(-77, dn.divide(-231,3));
        assertEquals(-2, dn.divide(7,-3));
        assertEquals(0, dn.divide(0,1));
        assertEquals(1, dn.divide(1,1));

    }

    @Test
    void divide3() {
        assertEquals(Integer.MAX_VALUE, dn.divide3(-2147483648,-1));
        assertEquals(1073741824, dn.divide3(-2147483648,-2));
        assertEquals(1073741823, dn.divide3(2147483647,2));
        assertEquals(-77, dn.divide3(-231,3));
        assertEquals(-2, dn.divide3(7,-3));
        assertEquals(0, dn.divide3(0,1));
        assertEquals(1, dn.divide3(1,1));
    }

    @Test
    void divide4() {
        assertEquals(Integer.MAX_VALUE, dn.divide4(-2147483648,-1));
        assertEquals(1073741824, dn.divide4(-2147483648,-2));
        assertEquals(1073741823, dn.divide4(2147483647,2));
        assertEquals(-77, dn.divide4(-231,3));
        assertEquals(-2, dn.divide4(7,-3));
        assertEquals(0, dn.divide4(0,1));
        assertEquals(1, dn.divide4(1,1));
    }
}