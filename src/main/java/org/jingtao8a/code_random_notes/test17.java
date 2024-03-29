package org.jingtao8a.code_random_notes;

import java.util.HashMap;
import java.util.Map;

public class test17 {
    public static boolean canConstruct(String ransom, String magazine) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); ++i) {
            Character ch = magazine.charAt(i);
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < ransom.length(); ++i) {
            Character ch = ransom.charAt(i);
            if (hashMap.containsKey(ch) && hashMap.get(ch) > 0) {
                hashMap.put(ch, hashMap.get(ch) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
    // 赎金信
    public static void main(String[] args) {
        String ransom = "abec", magazine = "abcd";
        System.out.println(canConstruct(ransom, magazine));
    }
}
