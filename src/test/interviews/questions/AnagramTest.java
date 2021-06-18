package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    Anagram anagram;

    @BeforeEach
    void init(){

        anagram = new Anagram();
    }

    @Test
    void isAnagramWithHashMap() {
        assertTrue(anagram.isAnagramWithHashMap("anagram","anagram"));
        assertTrue(anagram.isAnagramWithHashMap("tar","tat"));
    }

    @Test
    void isAnagram() {
        assertTrue(anagram.isAnagram("anagram","anagram"));
        assertTrue(anagram.isAnagram("tar","tat"));
    }
}