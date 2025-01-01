package org.jingtao8a.code_random_notes.SubstrWithoutRepeatChar;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private Set<Character> hashSet = new HashSet<>();
    public int lengthOfLongestSubstring(String s) {
        assert(s.length() >= 1);
        hashSet.add(s.charAt(0));
        int left = -1, right = 0;
        int res = right - left;
        while (right + 1 < s.length()) {
            ++right;
            while (hashSet.contains(s.charAt(right))) {
                left++;
                hashSet.remove(s.charAt(left));
            }
            hashSet.add(s.charAt(right));
            if (right - left > res) {
                res = right - left;
            }
        }
        return res;
    }
}
