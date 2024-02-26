package org.jingtao8a.hot100;

import com.sun.istack.internal.Nullable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class two_sum {
    private static class Data {
        long value;
        int index;
        Data(long value, int index) {
            this.index = index;
            this.value = value;
        }
    }
    public static @Nullable long[] twoSum(long[] num, long target) {
        if (num.length <= 1) {
            return null;
        }
        Data[] dataArray = new Data[num.length];
        for (int i = 0; i < num.length; ++i) {
            dataArray[i] = new Data(num[i], i);
        }
        Arrays.sort(dataArray, 0, num.length, (Data a, Data b) -> {
            return (int)(a.value - b.value);
        });

        int start  = 0, end = num.length - 1;
        while (start < end) {
            long sum = dataArray[start].value + dataArray[end].value;
            if (sum == target) {
                return new long[]{dataArray[start].index, dataArray[end].index};
            }
            if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return null;
    }
}
