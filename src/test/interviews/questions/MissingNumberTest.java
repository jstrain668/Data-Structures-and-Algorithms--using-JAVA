package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberTest {

    MissingNumber mn;
    int[] nums1;
    int[] nums2;
    int[] nums3;
    int[] nums4;

    @BeforeEach
    void init(){

        mn = new MissingNumber();
        nums1 = new int[] {3,0,1};
        nums2 = new int[] {0,1};
        nums3 = new int[] {9,6,4,2,3,5,7,0,1};
        nums4 = new int[] {0};
    }

    @Test
    void missingNumberUsingGauss() {
        assertEquals(2,mn.missingNumberUsingGauss(nums1));
        assertEquals(2,mn.missingNumberUsingGauss(nums2));
        assertEquals(8,mn.missingNumberUsingGauss(nums3));
        assertEquals(1,mn.missingNumberUsingGauss(nums4));
    }

    @Test
    void missingNumber() {
        assertEquals(2,mn.missingNumber(nums1));
        assertEquals(2,mn.missingNumber(nums2));
        assertEquals(8,mn.missingNumber(nums3));
        assertEquals(1,mn.missingNumber(nums4));
    }
}