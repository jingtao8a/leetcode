package org.jingtao8a.code_random_notes;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class zero_one_bag {
    int M;
    int N;
    int[] sizes;
    int[] values;

    public void init() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("D:/leetcode/input.txt");
        System.setIn(fileInputStream);
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();
        sizes = new int[M + 1];
        values = new int[M + 1];
        for (int i = 1; i <= M; ++i) {
            sizes[i] = scanner.nextInt();
        }
        for (int i = 1; i <= M; ++i) {
            values[i] = scanner.nextInt();
        }
    }

    public void print() {
        System.out.println(String.format("%d %d", M, N));
        for (int i = 1; i <= M; ++i) {
            System.out.print(sizes[i] + " ");
        }
        System.out.println();
        for (int i = 1; i <= M; ++i) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }

    public void solve() {
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 0; i <= M; ++i) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= N; ++j) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (j >= sizes[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - sizes[i]] + values[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[M][N]);
    }

    public static void main(String[] args) throws FileNotFoundException {
        zero_one_bag zeroOneBag = new zero_one_bag();
        zeroOneBag.init();
        zeroOneBag.print();
        zeroOneBag.solve();
    }
}
