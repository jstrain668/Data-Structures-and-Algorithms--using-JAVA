package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareRootTest {

    SquareRoot sr;

    @BeforeEach
    void init(){
        sr = new SquareRoot();
    }

    @Test
    void mySqrt() {
        assertEquals(2,sr.mySqrt(8));
        assertEquals(3,sr.mySqrt(10));
        assertEquals(4,sr.mySqrt(16));
    }

    @Test
    void binSearchSqRoot() {
        assertEquals(2,sr.binSearchSqRoot(8));
        assertEquals(3,sr.binSearchSqRoot(10));
        assertEquals(4,sr.binSearchSqRoot(16));
    }
}