package org.jingtao8a.hot100;


import org.junit.jupiter.api.Test;

public class two_sum_test {
    @Test
    public void test() {
        long[] res = two_sum.twoSum(new long[]{3,2,4}, 6);
        if (res != null) {
            for (long i : res) {
                System.out.println(i);
            }
        }
    }
}
