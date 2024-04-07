package org.jingtao8a.code_random_notes;

import java.util.ArrayList;

public class test38 {
    // 二叉搜索树的最小绝对值差
    public static void main(String[] args) {
        Integer[] integers = new Integer[] {8, 4, 10, 1, 7, 15};
        BinarySearchTree tree = BinarySearchTreeUtils.createBinarySearchTree(integers);
        ArrayList<Integer> arrayList = tree.getSortedArray();
        for (Integer i : arrayList) {
            System.out.print(i + " ");
        }
        System.out.println();
        int minAbsoluteValueDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arrayList.size() - 1; ++i) {
            int diff = arrayList.get(i + 1) - arrayList.get(i);
            minAbsoluteValueDiff = Math.min(minAbsoluteValueDiff, diff);
        }
        System.out.println(minAbsoluteValueDiff);
    }
}
