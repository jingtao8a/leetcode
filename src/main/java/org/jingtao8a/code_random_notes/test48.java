package org.jingtao8a.code_random_notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test48 {
    private static List<List<Integer> > combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    private static void dfs(List<List<Integer> > res, List<Integer> path, int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; ++i) {
            Integer num = candidates[i];
            if (sum + num > target) {
                break;
            }
            path.add(num);
            dfs(res, path, candidates, target, sum + num, i);
            path.remove(path.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer> > res = combinationSum(candidates, target);
        for (List<Integer> list : res) {
            System.out.print("[");
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }
}
