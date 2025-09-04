package org.jingtao8a.test;

import org.junit.jupiter.api.Test;

import java.util.*;

class Solution {
    Map<Character, Integer> tMap = new HashMap<>();
    Map<Character, Integer> sMap = new HashMap<>();
    String res = "";
    int len = Integer.MAX_VALUE;
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n <= 0) {
            return "";
        }
        for (int i = 0; i < m; ++i) {
            char ch = t.charAt(i);
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        int l = 0;
        int r = 0;
        sMap.put(s.charAt(0), 1);
        while (true) {
            if (isValid()) {
                do {
                    char ch = s.charAt(l);
                    sMap.put(ch, sMap.get(ch) - 1);
                    ++l;
                } while (isValid());
                --l;
                char ch = s.charAt(l);
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
                if (r - l + 1 < len) {
                    res = s.substring(l, r + 1);
                    len = r - l + 1;
                }
            }
            ++r;
            if (r >= s.length()) {
                break;
            }
            char ch = s.charAt(r);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }
        return res;
    }

    boolean isValid() {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            if (!sMap.containsKey(ch) || sMap.get(ch) < count) {
                return false;
            }
        }
        return true;
    }
}


public class test3 {
    @Test
    public void T1() {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ab", "a"));
    }
}
