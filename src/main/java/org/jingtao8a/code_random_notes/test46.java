package org.jingtao8a.code_random_notes;

import java.util.ArrayList;

public class test46 {
    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private static ArrayList<Integer> list = new ArrayList<>();
    private static int target = 9;
    private static int sum = 0;
    public static void dfs(int index, int n, int k) {
        list.add(index);
        sum += index;
        if (list.size() == k) {
            if (sum == target) {
                res.add((ArrayList<Integer>) list.clone());
            }
            sum -= index;
            list.remove(list.size() - 1);
            return;
        }
        for (int i = index + 1; i <= n - (k - list.size()); ++i) {
            dfs(i, n, k);
        }
        sum -= index;
        list.remove(list.size() - 1);
    }
    // 组合
    public static void main(String[] args) {
        int n = 9, k = 3;

        for (int i = 1; i <= n; ++i) {
            dfs(i, n, k);
        }
        for (ArrayList<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
