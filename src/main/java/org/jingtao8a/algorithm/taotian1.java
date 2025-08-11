package org.jingtao8a.algorithm;
import java.util.Scanner;
public class taotian1 {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            int n = str.length();
            int profit = 0;
            for (int i = 0; i < n; ++i) {
                int zero = 0;
                int one = 0;
                for (int j = i; j >= 0; --j) {
                    if (str.charAt(j) == '0') {
                        ++zero;
                    } else {
                        ++one;
                    }
                    profit = Math.max(profit, zero - one);
                }
            }
            int totalOne = 0;
            for (int i = 0; i < n; ++i) {
                if (str.charAt(i) == '1') {
                    ++totalOne;
                }
            }
            System.out.println(totalOne + profit);
        }
}
