package org.jingtao8a.hot100;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubString {
    public static int func(String s) {
        Set<Character> set = new HashSet<>();
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int front = -1, end = 0;
        set.add(s.charAt(end));
        ++end;
        while (end < s.length()) {
            char ch = s.charAt(end);
            if (set.contains(ch)) {
                while (!set.contains(ch)) {
                    ++front;
                    set.remove(s.charAt(front));
                }
                set.add(ch);
            } else {
                set.add(ch);
            }
            res = Math.max(res, end - front);
            ++end;
        }
        res = Math.max(res, end - front - 1);
        return res;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(func(s));
    }
}
