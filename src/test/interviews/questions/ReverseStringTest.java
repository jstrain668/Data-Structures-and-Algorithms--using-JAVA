package interviews.questions;


import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    ReverseString rs;

    @BeforeEach
    public void init(){
        rs = new ReverseString();

    }

    @Test
    void reverseString() {
        assertEquals("", rs.reverseString(""));
    }

    @Test public void reverseNullString(){
        assertEquals(null, rs.reverseString(null));
    }

    @Test public void reversePalindromeString(){
        assertEquals("aba", rs.reverseString("aba"));

    }

    @Test public void reverseSameCharacterString(){
        assertEquals("aaa", rs.reverseString("aaa"));
    }

    @Test public void reverseAnagramString(){
        assertEquals("mary", rs.reverseString("yram"));
    }
}