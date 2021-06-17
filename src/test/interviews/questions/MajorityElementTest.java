package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {

    MajorityElement me;
    int[] nums = new int[] {3,2,3};
    int[] nums1 = new int[] {2,2,1,1,1,2,2};

    @BeforeEach
    void init(){

        me = new MajorityElement();
    }

    @Test
    void bfMajorityElement() {

        assertEquals(3,me.bfMajorityElement(nums));
        assertEquals(2,me.bfMajorityElement(nums1));
    }

    @Test
    void effMajorityElement() {
        assertEquals(3,me.effMajorityElement(nums));
        assertEquals(2,me.effMajorityElement(nums1));
    }

    @Test
    void majorityElement() {
        assertEquals(3,me.majorityElement(nums));
        assertEquals(2,me.majorityElement(nums1));
    }
}