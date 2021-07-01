package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    LongestCommonPrefix lcp;
    String[] strings;
    String[] input;
    String[] strs;
    String[] misc;

    @BeforeEach
    void init(){
        lcp = new LongestCommonPrefix();
        strings = new String[] {"flower","flow","flo","flight"};
        input = new String[] {"geeksforgeeks", "geeks", "geek", "geezer"};
        strs = new String[] {"leet","leader"};
        misc = new String[] {"car","dog","racecar"};

    }

    @Test
    void longestCommonPrefix() {
        assertEquals("fl",lcp.longestCommonPrefix(strings));
        assertEquals("gee",lcp.longestCommonPrefix(input));
        assertEquals("le",lcp.longestCommonPrefix(strs));
        assertEquals("",lcp.longestCommonPrefix(misc));
    }

    @Test
    void longestCommonPrefixUsingSort() {
        assertEquals("fl",lcp.longestCommonPrefixUsingSort(strings));
        assertEquals("gee",lcp.longestCommonPrefixUsingSort(input));
        assertEquals("le",lcp.longestCommonPrefixUsingSort(strs));
        assertEquals("",lcp.longestCommonPrefixUsingSort(misc));
    }
}