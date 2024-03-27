package org.jingtao8a.hot100;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        if (nums == null || nums.length <= 1) {
            return res;
        }
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);

        nums = new int[]{3, 2, 4};
        target = 6;
        res = twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
