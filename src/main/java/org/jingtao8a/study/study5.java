package org.jingtao8a.study;

public class study5 {
    private static int partition(int[] nums, int left, int right) {
        int mid = (left + right) >> 1;
        swap(nums, left, mid);
        int pivot = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (nums[j] < pivot && i < j) {
                --j;
            }
            while (nums[i] >= pivot && i < j) {
                ++i;
            }
            if (i != j) {
                swap(nums, i, j);
            }
        }
        swap(nums, i, left);
        return i;
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(nums, left, right);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
