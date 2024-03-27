package org.jingtao8a.code_random_notes;

public class test1 {
    public static int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,3,5,9,12};
        System.out.println(lowerBound(nums, 3));
        System.out.println(lowerBound(nums, 5));
        System.out.println(lowerBound(nums, -1));
        System.out.println(upperBound(nums, 3));
    }
}
