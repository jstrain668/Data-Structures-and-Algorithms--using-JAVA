package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitwiseOperationsTest {

    BitwiseOperations bo;

    @BeforeEach
    public void init(){
        bo = new BitwiseOperations();
    }

    @Test
    void add() {

        assertEquals(10,bo.add(5,5));
    }

    @Test
    void subtract() {
        assertEquals(0,bo.subtract(5,5));

    }
}