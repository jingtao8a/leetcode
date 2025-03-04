package org.jingtao8a.leetcode101;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class AssignCookies {
    int n;
    int m;
    Integer[] children;
    Integer[] cookies;
    public void init() {
        try {
            System.setIn(new FileInputStream("D:/leetcode/leetcode101_input/AssignCookies.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner= new Scanner(System.in);
        n = scanner.nextInt();
        children = new Integer[n];
        for (int i = 0; i < n; ++i) {
            children[i] = scanner.nextInt();
        }
        m = scanner.nextInt();
        cookies = new Integer[m];
        for (int i = 0; i < m; ++i) {
            cookies[i] = scanner.nextInt();
        }
    }

    public int solve() {
        Arrays.sort(cookies);
        Arrays.sort(children);
        int index = 0;
        int count = 0;
        for (int i = 0; i < m; ++i) {
            if (cookies[i] > children[index]) {
                ++count;
                ++index;
                if (index >= n) {
                    break;
                }
            }
        }
        return count;
    }
    @Test
    public void mainTest() {
        AssignCookies assignCookies = new AssignCookies();
        assignCookies.init();
        System.out.println(assignCookies.solve());
    }
}
