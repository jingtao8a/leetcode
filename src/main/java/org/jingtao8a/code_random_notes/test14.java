package org.jingtao8a.code_random_notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test14 {
    public static ArrayList<Integer> intercetionOfTwoArray(int[] num1, int[] num2) {
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        for (int i : num1) {
            if (hashMap1.containsKey(i)) {
                hashMap1.put(i, hashMap1.get(i) + 1);
            } else {
                hashMap1.put(i, 1);
            }
        }
        for (int i : num2) {
            if (hashMap2.containsKey(i)) {
                hashMap2.put(i, hashMap2.get(i) + 1);
            } else {
                hashMap2.put(i, 1);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hashMap1.entrySet()) {
            if (hashMap2.containsKey(entry.getKey())) {
                int num = Math.min(hashMap1.get(entry.getKey()), hashMap2.get(entry.getKey()));
                for (int i = 1; i <= num; ++i) {
                    arrayList.add(entry.getKey());
                }
            }
        }
        return arrayList;
    }
    public static void main(String[] args) {
        int[] num1 = new int[] {1, 2, 2, 1};
        int[] num2 = new int[] {2, 2};
        ArrayList<Integer> array = intercetionOfTwoArray(num1, num2);
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        num1 = new int[] {4, 9, 5};
        num2 = new int[] {9, 4, 9, 8, 4};
        array = intercetionOfTwoArray(num1, num2);
        for (Integer i : array) {
            System.out.print(i + " ");
        }
    }
}
