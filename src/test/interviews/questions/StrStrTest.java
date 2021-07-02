package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrStrTest {

    StrStr ss;

    @BeforeEach
    void init(){
        ss = new StrStr();
    }

    @Test
    void strStrIndexOf() {

        assertEquals(2,ss.strStrIndexOf("hello","ll"));
        assertEquals(5,ss.strStrIndexOf("geeksforgeeks","for"));
    }

    @Test
    void strStr() {

        assertEquals(2,ss.strStr("hello","ll"));
        assertEquals(5,ss.strStr("geeksforgeeks","for"));
    }
}