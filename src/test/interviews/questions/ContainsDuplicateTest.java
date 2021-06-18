package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {

    ContainsDuplicate cd;

    @BeforeEach
    void init(){
        cd = new ContainsDuplicate();
    }

    @Test
    void containsDuplicate() {

        int[] nums1 = new int[]{1,2,3,1};
        int[] nums2 = new int[]{1,2,3,4};
        assertTrue(cd.containsDuplicate(nums1));
        assertFalse(cd.containsDuplicate(nums2));
    }
}