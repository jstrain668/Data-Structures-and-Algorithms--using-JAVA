package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxDepthOfTreeTest {

    MaxDepthOfTree mdt;


    @BeforeEach
    public void init(){
        mdt = new MaxDepthOfTree();
    }

    @Test
    void maxDepth() {
        mdt.insert(3);
        mdt.insert(9);
        mdt.insert(20);
        mdt.insert(15);
        mdt.insert(7);
        assertEquals(4,mdt.maxDepth(mdt.getRoot()));
    }
}