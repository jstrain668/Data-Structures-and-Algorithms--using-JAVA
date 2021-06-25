package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfThreeTest {

    PowerOfThree pot;

    @BeforeEach
    void init(){
        pot = new PowerOfThree();
    }


    @Test
    void isPowerOfThree() {

        assertTrue(pot.isPowerOfThree(1));
        assertTrue(pot.isPowerOfThree(27));
        assertTrue(pot.isPowerOfThree(3));
        assertFalse(pot.isPowerOfThree(45));
    }
}