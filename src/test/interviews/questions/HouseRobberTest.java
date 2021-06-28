package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {

    HouseRobber hr;
    int[] nums1;
    int[] nums2;
    int[] nums3;

    @BeforeEach
    void init(){

        hr = new HouseRobber();
        nums1 = new int[] {1,2,3,1};
        nums2 = new int[] {6, 7, 1, 3, 8, 2, 4};
        nums3 = new int[] {2,1,1,2};
    }

    @Test
    void rob() {
        assertEquals(4,hr.rob(nums1));
        assertEquals(19,hr.rob(nums2));
        assertEquals(4,hr.rob(nums3));
    }

    @Test
    void dpRob() {
        assertEquals(4,hr.dpRob(nums1));
        assertEquals(19,hr.dpRob(nums2));
        assertEquals(4,hr.dpRob(nums3));
    }

    @Test
    void altRob() {
        assertEquals(4,hr.altRob(nums1));
        assertEquals(19,hr.altRob(nums2));
        assertEquals(4,hr.altRob(nums3));
    }
}