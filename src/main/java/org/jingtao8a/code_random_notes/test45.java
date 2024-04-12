package org.jingtao8a.code_random_notes;

import java.util.ArrayList;

public class test45 {
    private static ArrayList<ArrayList<Integer> > res = new ArrayList<>();
    private static ArrayList<Integer> list = new ArrayList<>();
    public static void dfs(int index, int n, int k) {
        list.add(index);
        if (list.size() == k) {
            res.add((ArrayList<Integer>) list.clone());
            list.remove(list.size() - 1);
            return;
        }
        for (int i = index + 1; i <= n - (k - list.size()); ++i) {
            dfs(i, n, k);
        }
        list.remove(list.size() - 1);
    }
    // 组合
    public static void main(String[] args) {
        int n = 4, k = 2;

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
