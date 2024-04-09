package org.jingtao8a.code_random_notes;

import java.util.ArrayList;

public class test39 {
    // 二叉搜索树中的众数
    public static void main(String[] args) {
        Integer[] array = new Integer[] {5, 1, 3, 6, 6, 6, 7, 7, 7, 2, 2};
        BinarySearchTree binarySearchTree = BinarySearchTreeUtils.createBinarySearchTree(array);

        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> list = binarySearchTree.getSortedArray();
        int count = 0;
        int num = 0;

        int front = 0, end = 0;
        ++end;
        while (end < list.size()) {
            if (list.get(end) == list.get(front)) {
                ++end;
            } else {
                if (end - front > count) {
                    count = end - front;
                    num = list.get(front);
                    res.clear();
                    res.add(num);
                } else if (end - front  == count) {
                    num = list.get(front);
                    res.add(num);
                }
                front = end;
                ++end;
            }
        }
        if (end - front > count) {
            count = end - front;
            num = list.get(front);
            res.clear();
            res.add(num);
        } else if (end - front == count) {
            num = list.get(front);
            res.add(num);
        }
        for (Integer i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("count : " + count);
    }
}
