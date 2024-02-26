package org.jingtao8a.study;


import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int front = -1, end = 0;
        int res = 0;
        while (end < s.length()) {
            if (!map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), end);
                end++;
            } else {
                res = Math.max(res, end - front - 1);// update res
                int newFront = map.get(s.charAt(end));
                while (front < newFront) {
                    front++;
                    map.remove(s.charAt(front));
                }
            }
        }
        res = Math.max(res, end - front - 1);// update res
        return res;
    }
}

public class study1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abba"));
    }
}
