package org.jingtao8a.code_random_notes;

public class test2 {
    public static int removeValue(int[] nums, int val) {
        int front = -1, end = 0;
        while (end < nums.length) {
            if (nums[end] != val) {
                ++front;
                nums[front] = nums[end];
            }
            ++end;
        }
        return front + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int n = removeValue(nums, 2);
        for (int i = 0; i < n; ++i) {
            System.out.println(nums[i]);
        }
    }
}
