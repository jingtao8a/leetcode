package org.jingtao8a.huawei;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BinarySearch {

    @Test
    public void TestBinarySearch() {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Arrays.sort(array);
        int index = lowBound(array, 0, array.length, 10);
//        int index = upperBound(array, 0, array.length, 10);
        System.out.println(index);
    }

    public int lowBound(int[] array, int left, int right, int target) {
        if (right < left) {
            return Integer.MIN_VALUE;
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            if (array[mid] > target) {
                right = mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int upperBound(int[] array, int left, int right, int target) {
        if (right < left) {
            return Integer.MIN_VALUE;
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            if (array[mid] > target) {
                right = mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
