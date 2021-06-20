package interviews.questions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstUniqueCharacterTest {

    FirstUniqueCharacter fuc;

    @BeforeEach
    void init(){

        fuc = new FirstUniqueCharacter();
    }

    @Test
    void firstUniqueCharWithHashMap() {
        String str1 = "leetcode";
        String str2 = "loveleetcode";
        String str3 = "aabb";
        assertEquals(0,fuc.firstUniqueCharWithHashMap(str1));
        assertEquals(2,fuc.firstUniqueCharWithHashMap(str2));
        assertEquals(-1,fuc.firstUniqueCharWithHashMap(str3));
    }

    @Test
    void firstUniqueChar() {
        String str1 = "leetcode";
        String str2 = "loveleetcode";
        String str3 = "aabb";
        assertEquals(0,fuc.firstUniqueChar(str1));
        assertEquals(2,fuc.firstUniqueChar(str2));
        assertEquals(-1,fuc.firstUniqueChar(str3));
    }
}