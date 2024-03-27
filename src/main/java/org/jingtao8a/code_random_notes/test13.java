package org.jingtao8a.code_random_notes;

import java.util.HashMap;

public class test13 {
    public static HashMap<Character, Integer> countCharacterNum(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            Character ch = s.charAt(i);
            if (hashMap.containsKey(ch)) {
                hashMap.put(ch, hashMap.get(ch) + 1);
            } else {
                hashMap.put(ch, 1);
            }
        }
        return hashMap;
    }

    // 有效的字母异味词
    public static boolean judgeAllOphone(String s, String t) {
        HashMap<Character, Integer> hashMap1 = countCharacterNum(s);
        HashMap<Character, Integer> hashMap2 = countCharacterNum(t);
        for (Character ch = 'a'; ch <= 'z'; ++ch) {
            Integer num1 = hashMap1.get(ch);
            Integer num2 = hashMap2.get(ch);
            if (num1 == null && num2 == null) {
                continue;
            }
            if (num1 != null && num2 != null) {
                if (num1 != num2) {
                    return false;
                }
                continue;
            }
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(judgeAllOphone(s, t));
        s = "rat";
        t = "car";
        System.out.println(judgeAllOphone(s, t));
    }
}
