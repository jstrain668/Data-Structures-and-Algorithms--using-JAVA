package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    TwoSum ts;
    int[] nums1;
    int[] nums2;
    int[] nums3;

    @BeforeEach
    void init(){
        ts = new TwoSum();
        nums1 = new int[] {2,7,11,15};
        nums2 = new int[] {3,2,4};
        nums3 = new int[] {3,3};
    }

    @Test
    void twoSum() {
        assertArrayEquals(new int[] {1,0}, ts.twoSum(nums1,9));
        assertArrayEquals(new int[] {2,1}, ts.twoSum(nums2,6));
        assertArrayEquals(new int[] {0,1}, ts.twoSum(nums3,6));
    }

    @Test
    void findPairWithSum() {
        assertArrayEquals(new int[] {1,0}, ts.findPairWithSum(nums1,9));
        assertArrayEquals(new int[] {2,1}, ts.findPairWithSum(nums2,6));
        assertArrayEquals(new int[] {1,0}, ts.findPairWithSum(nums3,6));
    }
}