package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    FizzBuzz fb;
    List<String> list1;
    List<String> list2;
    List<String> list3;

    @BeforeEach
    public void init(){
        fb = new FizzBuzz();
        list1 = Arrays.asList("1", "2", "Fizz");
        list2 = Arrays.asList("1", "2", "Fizz","4","Buzz");
        list3 = Arrays.asList("1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz");
    }

    @Test
    void fizzBuzz() {
        assertEquals(list1,fb.fizzBuzz(3));
        assertEquals(list2,fb.fizzBuzz(5));
        assertEquals(list3,fb.fizzBuzz(15));
    }
}