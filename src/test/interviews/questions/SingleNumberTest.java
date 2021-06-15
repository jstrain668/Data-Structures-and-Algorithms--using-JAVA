package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleNumberTest {

    SingleNumber sn;
    int[] nums;

    @BeforeEach
    public void init(){
        sn = new SingleNumber();
    }

    @Test
    void singleNumber() {
        nums = new int[] {4,1,2,1,2};
        assertEquals(4, sn.singleNumber(nums));
        assertEquals(4, sn.singleNumberXOR(nums));
        nums = new int[] {1};
        assertEquals(1, sn.singleNumber(nums));
        assertEquals(1, sn.singleNumberXOR(nums));
        nums = new int[] {2,2,1};
        assertEquals(1, sn.singleNumber(nums));
        assertEquals(1, sn.singleNumberXOR(nums));
        nums = new int[] {1,2,1};
        assertEquals(2, sn.singleNumber(nums));
        assertEquals(2, sn.singleNumberXOR(nums));
    }

    @Test
    public void testIllegalArgumentExceptionForEmptyArray() {
        assertThrows(IllegalArgumentException.class,() ->sn.singleNumber(nums));
        assertThrows(IllegalArgumentException.class,() ->sn.singleNumberXOR(nums));
    }

    @Test
    public void testIllegalArgumentExceptionForNoUniqueValue() {
        nums = new int[] {1,1,3,3};
        assertThrows(IllegalArgumentException.class,() ->sn.singleNumber(nums));
        //assertThrows(IllegalArgumentException.class,() ->sn.singleNumberXOR(nums));
    }
}