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


    private static void merge(int[] num, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        //num[left ~ mid] num[mid + 1 ~ right]
        while (i <= mid && j <= right) {
            if (num[i] < num[j]) {
                tmp[k++] = num[i++];
            } else {
                tmp[k++] = num[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = num[i++];
        }
        while (j <= right) {
            tmp[k++] = num[j++];
        }

        for (i = left, k = 0; i <= right; ++i, ++k) {
            num[i] = tmp[k];
        }
    }

    public static void mergeSort(int[] num, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(num, left, mid);
        mergeSort(num, mid + 1, right);
        merge(num, left, mid, right);
    }

    private static void shiftDown(int[] num, int i, int n) {
        while (true) {
            int l = (i + 1) * 2 - 1;
            int r = (i + 1) * 2;
            if (l >= n) {
                return;
            }
            int swapIndex = l;
            if (r < n && num[r] > num[l]) {
                swapIndex = r;
            }
            if (num[i] < num[swapIndex]) {
                swap(num, i, swapIndex);
                i = swapIndex;
            } else {
                return;
            }
        }
    }
    public static void heapSort(int[] num) {
        //建堆, 0 ~ num.length - 1 ---> 1 ~ num.length
        for (int i = num.length / 2 - 1; i >= 0; --i) {
            shiftDown(num, i, num.length);
        }
        // 从堆中提取最大元素
        int k = 0;
        for (int i = num.length - 1; i >= 0; --i) {
            swap(num, i, 0);
            ++k;
            shiftDown(num, 0, num.length - k);
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{23, 432, 24, 89, 239, 98};
        heapSort(num);
        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}
