package org.jingtao8a.code_random_notes;

import java.util.HashSet;
import java.util.Set;

public class test15 {
    public static boolean judgeHappyNumber(int num) {
        Set<Integer> hashSet = new HashSet<>();
        int cycleNum = num;
        while (!hashSet.contains(cycleNum)) {
            hashSet.add(cycleNum);
            cycleNum = getNextNumInCycle(cycleNum);
            if (cycleNum == 1) {
                for (Integer i : hashSet) {
                    System.out.print(i + " ");
                }
                return true;
            }
        }
        for (Integer i : hashSet) {
            System.out.print(i + " ");
        }
        return false;
    }

    public static int getNextNumInCycle(int num) {
        int sum = 0;
        while (num >  0) {
            int i = num % 10;
            sum += i * i;
            num = num / 10;
        }
        return sum;
    }
    //快乐数
    public static void main(String[] args) {
        System.out.println(judgeHappyNumber(19));
    }
}
