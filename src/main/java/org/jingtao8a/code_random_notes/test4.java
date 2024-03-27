package org.jingtao8a.code_random_notes;

public class test4 {
    public static int subArrayWithMinimumLength(int[] nums, int s) {
        int res = Integer.MAX_VALUE;
        int front = -1, end = -1;
        int sum = 0;
        ++end;
        while (end < nums.length) {
            sum += nums[end];
            if (sum >= s) {
                res = Math.min(end - front, res);
                ++front;
                sum -= nums[front];
                while (sum >= s) {
                    res = Math.min(end - front, res);
                    ++front;
                    sum -= nums[front];
                }
            }
            ++end;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(subArrayWithMinimumLength(nums, 7));
    }
}
