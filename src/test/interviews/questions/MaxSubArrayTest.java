package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubArrayTest {

    MaxSubArray msa;

    @BeforeEach
    void init(){

        msa = new MaxSubArray();
    }

    @Test
    void bfMaxSubArray() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums1 = {1};
        int[] nums2 = {5,4,-1,7,8};
        int[] nums3 = {-1,-1,-2,-2};

        assertEquals(6,msa.bfMaxSubArray(nums));
        assertEquals(1,msa.bfMaxSubArray(nums1));
        assertEquals(23,msa.bfMaxSubArray(nums2));
        assertEquals(-1,msa.bfMaxSubArray(nums3));
    }

    @Test
    void maxSubArray() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums1 = {1};
        int[] nums2 = {5,4,-1,7,8};
        int[] nums3 = {-1,-1,-2,-2};

        assertEquals(6,msa.maxSubArray(nums));
        assertEquals(1,msa.maxSubArray(nums1));
        assertEquals(23,msa.maxSubArray(nums2));
        assertEquals(-1,msa.maxSubArray(nums3));
    }
}