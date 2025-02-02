package org.jingtao8a.study;

public class study5 {
    private static int randomInt(int min, int max) {
        return (int)Math.random() * (max - min) + min;
    }

    private static int partition(int[] arr, int left, int right) {
        int tmp = randomInt(left, right);
        swap(arr, left, tmp);
        int pivot = arr[left];
        int i = left;
        for (int j = left + 1; j <= right; ++j) {
            if (arr[j] <= pivot) {
                ++i;
                if (i != j) {
                    swap(arr, i, j);
                }
            }
        }
        swap(arr, left, i);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(arr, left, right);
        quickSort(arr, left, mid - 1);
        quickSort(arr, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
