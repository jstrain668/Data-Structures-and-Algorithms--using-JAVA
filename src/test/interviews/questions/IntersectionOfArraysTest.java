package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionOfArraysTest {

    IntersectionOfArrays ioa;
    int[] nums1;
    int[] nums2;
    int[] nums3;
    int[] nums4;
    int[] result;

    @BeforeEach
    void init(){
        ioa = new IntersectionOfArrays();
        nums1 = new int[] {1,2,2,1};
        nums2 = new int[] {2,2};
        nums3 = new int[] {4,9,5};
        nums4 = new int[] {9,4,9,8,4};
    }

    @Test
    void intersect() {

        result = new int[] {2,2};
        assertArrayEquals(result,ioa.intersect(nums1,nums2));
        result = new int[] {4,9};
        int[] output = ioa.intersect(nums3,nums4);
        Arrays.sort(output);
        assertArrayEquals(result, output);
    }
}