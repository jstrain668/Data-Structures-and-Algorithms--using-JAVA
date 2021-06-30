package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    ValidParentheses vp;


    @BeforeEach
    void init(){

        vp = new ValidParentheses();
    }

    @Test
    void isValid() {
        assertTrue(vp.isValid("{[]}"));
        assertFalse(vp.isValid("(("));
        assertTrue(vp.isValid("()[]{}"));
    }
}