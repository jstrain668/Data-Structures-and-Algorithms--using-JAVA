package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MoveZeroesTest {

    MoveZeroes mz;
    int[] nums1 = new int[] {0,0,1,3,12};
    int[] nums2 = new int[] {0,1,0,3,12};
    int[] nums3 = new int[] {1,0,1};
    int[] nums4 = new int[] {0,1,0};

    @BeforeEach
    public void init(){
        mz = new MoveZeroes();
    }

    @Test
    void moveZeroes() {
        mz.moveZeroes(nums1);
        assertArrayEquals(new int[] {1,3,12,0,0},nums1);
        mz.moveZeroes(nums2);
        assertArrayEquals(new int[] {1,3,12,0,0},nums2);
        mz.moveZeroes(nums3);
        assertArrayEquals(new int[] {1,1,0},nums3);
        mz.moveZeroes(nums4);
        assertArrayEquals(new int[] {1,0,0},nums4);
    }
}