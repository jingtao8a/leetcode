package org.jingtao8a.test;

import org.junit.jupiter.api.Test;
import java.util.*;

public class test2 {
    @Test
    public void T1() {
        int[] array = {1, 2, 3, 3, 4, 5};
        Set<Integer> set = new HashSet<>();
        int res = 1;
        for (int num : array) {
            set.add(num);
            set.add(num - 1);
            set.add(num + 1);
        }
        for (int x : set) {
            int count = 0;
            for (int num : array) {
                if (Math.abs(num - x) <= 1) {
                    ++count;
                }
            }
            res = Math.max(res, count);
        }
        System.out.println(res);
    }

}
