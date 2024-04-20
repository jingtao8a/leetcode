package org.jingtao8a.code_random_notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class test53 {
    //递增子序列
    private static List<List<Integer>> lists = new ArrayList<>();
    private static LinkedList<Integer> path = new LinkedList<>();
    public static List<List<Integer> > subsets(int[] nums) {
        lists.clear();
        path.clear();
        Arrays.sort(nums);
        dfs(nums, 0);
        return lists;
    }

    public static void dfs(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            lists.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < nums.length; ++i) {
            if (i > startIndex && nums[i - 1] == nums[i]) {//跳过当前层使用过的重复元素
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.removeLast();
        }
    }

    public static void printRes(List<List<Integer> > res) {
        for (List<Integer> list : res) {
            System.out.print("[ ");
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println(" ]");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] num = new int[] {4, 6, 7, 7};
        printRes(subsets(num));
    }
}
