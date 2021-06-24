package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbStairsTest {

    ClimbStairs cs;

    @BeforeEach
    void init(){
        cs = new ClimbStairs();
    }

    @Test
    void climbStairs() {
        assertEquals(3,cs.climbStairs(3));
        assertEquals(8,cs.climbStairs(5));
    }

    @Test
    void climbStairsUsingCache() {
        assertEquals(3,cs.climbStairsUsingCache(3));
        assertEquals(8,cs.climbStairsUsingCache(5));
    }
}