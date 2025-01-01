package org.jingtao8a.SubstrWithoutRepeatChar;

import org.jingtao8a.code_random_notes.SubstrWithoutRepeatChar.Solution;
import org.junit.Test;
import static org.junit.Assert.*;


public class Test1 {
    @Test
    public void test1() {
        Solution solution = new Solution();
        assertEquals(3, (long)solution.lengthOfLongestSubstring("abcabc"));
        assertEquals(1, (long)solution.lengthOfLongestSubstring("bbb"));
    }
}
