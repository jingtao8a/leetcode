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

    @Test
    public void T2() {
        backTrack(1);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    int M = 3;
    int N = 10;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> group = new ArrayList<>();
    void backTrack(int start) {
        if (group.size() == M) {
            res.add(new ArrayList<>(group));
            return;
        }
        for (int i = start; i <= N; ++i) {
            group.add(i);
            backTrack(i + 1);
            group.remove(group.size() - 1);
        }
    }
}
