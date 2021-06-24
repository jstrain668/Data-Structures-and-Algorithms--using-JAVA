package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HappyNumberTest {

    HappyNumber hn;

    @BeforeEach
    void init(){

        hn = new HappyNumber();
    }

    @Test
    void isHappy() {

        assertTrue(hn.isHappy(19));
        assertTrue(hn.isHappy(31));
        assertTrue(hn.isHappy(97));
        assertFalse(hn.isHappy(5));
        assertFalse(hn.isHappy(9));
        assertFalse(hn.isHappy(24));
    }
}