package org.jingtao8a.leetcode101;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Non_overlapping_Intervals {
    int n;
    int[][] intervals;
    public void init() {
        try {
            System.setIn(new FileInputStream("D:/leetcode/leetcode101_input/Non_overlapping_Intervals.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
    }

    public int solve() {
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });
        int count = 1;
        int last = intervals[0][1];
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= last) {
                ++count;
                last = intervals[i][1];
            }
        }
        return n - count;
    }

    @Test
    public void mainTest() {
        Non_overlapping_Intervals non_overlapping_intervals = new Non_overlapping_Intervals();
        non_overlapping_intervals.init();
        System.out.println(non_overlapping_intervals.solve());
    }
}
