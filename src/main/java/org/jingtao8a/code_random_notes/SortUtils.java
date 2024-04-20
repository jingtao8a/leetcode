package org.jingtao8a.code_random_notes;

public class SortUtils {
    public static void quickSort(int[] num, int start, int end) {
        if (start < end) {
            int partionIndex = partition(num, start, end);
            quickSort(num, start, partionIndex - 1);
            quickSort(num, partionIndex + 1, end);
        }
    }

    private static int partition(int[] num, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; ++i) {
            if (num[i] < num[pivot]) {
                swap(num, i, index);
                index++;
            }
        }
        swap(num, pivot, index - 1);
        return index - 1;
    }

    public static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void main(String[] args) {
        int[] num = new int[]{23, 432, 24, 89, 239, 98};
        quickSort(num, 0, num.length - 1);
        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}
