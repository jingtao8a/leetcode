package org.jingtao8a.huawei;

import org.junit.jupiter.api.Test;
import java.util.*;

public class Study1 {
    @Test
    public void changeBottle() {
        int N = 10; // 初始水瓶
        int res = 0;
        while (N / 3 >= 1) {
            int tmp = N / 3;
            N %= 3;
            res += tmp;
            N += tmp;
        }
        if (N == 2) {
            res += 1;
        }
        System.out.println(res);
    }

    @Test
    public void studentSurvey() {
        Set<Integer> treeSet = new TreeSet<>();
        int N = 10;
        Random random = new Random();
        for (int i = 0; i < N; ++i) {
            treeSet.add(random.nextInt(1000) + 1);
        }
        for (int i : treeSet) {
            System.out.println(i);
        }
    }

    @Test
    public void hex2dec() {
        String hexStr = "ABC";
        int n = hexStr.length();
        int base = 1;
        int res = 0;
        for (int i = n - 1; i >= 0; --i) {
            res += getNum(hexStr.charAt(i)) * base;
            base *= 16;
        }
        System.out.println(res);
    }
    int getNum(char ch) {
        if (ch >= '0' && ch <= '9') {
            return ch - '0';
        }
        return ch - 'A' + 10;
    }
}
