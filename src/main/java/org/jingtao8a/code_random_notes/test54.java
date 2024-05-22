package org.jingtao8a.code_random_notes;

import java.util.ArrayList;
import java.util.List;

public class test54 {
    //全排列
    private static List<List<Integer>> result = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();
    private static boolean[] used;
    public static void permute(int[] num) {
        if (path.size() == num.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < num.length; ++i) {
            if (used[i] == true) {
                continue;
            }
            used[i] = true;
            path.add(num[i]);
            permute(num);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3};
        used = new boolean[num.length];
        permute(num);
//        for (int i = 0; i < used.length; ++i) {
//            System.out.println(used[i]);
//        }
        for (List<Integer> list : result) {
            System.out.print("[");
            for (Integer i : list) {
                System.out.print(i + ", ");
            }
            System.out.println(" ]");
        }
    }
}
