package org.jingtao8a.study;


import org.jingtao8a.code_random_notes.SortUtils;

public class study3 {

    static void shiftDown(int[] array, int i, int n) {
        int index = 2 * i;
        if (index > n) {
            return;
        }
        if (index + 1 <= n && array[index + 1] > array[index]) {
            ++index;
        }
        if (array[i] < array[index]) {
//            System.out.println("swap " + array[i] + " " + array[index]);
            SortUtils.swap(array, i, index);
            shiftDown(array, index, n);
        }
    }

    public static void heapSort(int[] array) {
        int n = array.length - 1;
        for (int i = n / 2; i >= 1; --i) {
            shiftDown(array, i, n);
        }
        for (int i = n; i > 1; --i) {
            SortUtils.swap(array, 1, i);
            shiftDown(array, 1, i - 1);
        }
    }


    public static void main(String[] args) {
        int[] array = {-1, 23, 13290, 21, 1, 834};
        heapSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
