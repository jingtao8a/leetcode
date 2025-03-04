package org.jingtao8a.leetcode101;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Candy {
    int n;
    Integer[] children;
    public void init() {
        try {
            System.setIn(new FileInputStream("D:/leetcode/leetcode101_input/Candy.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner= new Scanner(System.in);
        n = scanner.nextInt();
        children = new Integer[n];
        for (int i = 0; i < n; ++i) {
            children[i] = scanner.nextInt();
        }
    }

    public int solve() {
        int count = 0;
        int[] candys = new int[n];
        Arrays.fill(candys, 1);
        for (int i = 1; i < n; ++i) {
            if (children[i] > children[i - 1] && candys[i] <= candys[i - 1]) {
                candys[i] = candys[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; --i) {
            if (children[i] > children[i + 1] && candys[i] <= candys[i + 1]) {
                candys[i] = candys[i + 1] + 1;
            }
        }
        for (int i : candys) {
            count += i;
        }
        return count;
    }
    @Test
    public void mainTest() {
        Candy candy = new Candy();
        candy.init();
        System.out.println(candy.solve());
    }
}
