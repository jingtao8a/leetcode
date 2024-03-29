package org.jingtao8a.code_random_notes;

import java.util.HashMap;
import java.util.Map;

public class test16 {
    public static int sumOfFourNum(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                hashMap.put(i + j, hashMap.getOrDefault(i + j, 0) + 1);
            }
        }
        for (int i : C) {
            for (int j : D) {
                if (hashMap.containsKey(-(i + j))) {
                    res += hashMap.get(-(i + j));
                }
            }
        }
        return res;
    }
    // 四数相加II
    public static void main(String[] args) {
        int[] A = new int[] {1, 2};
        int[] B = new int[] {-2, -1};
        int[] C = new int[] {-1, 2};
        int[] D = new int[] {0, 2};
        System.out.println(sumOfFourNum(A, B, C, D));
    }
}
