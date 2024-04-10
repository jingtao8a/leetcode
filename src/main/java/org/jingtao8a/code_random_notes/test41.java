package org.jingtao8a.code_random_notes;

import java.util.ArrayList;

public class test41 {
    public static void main(String[] args) {
        Integer[] integers = new Integer[] {6, 8, 2, 0, 4, 3, 5, 7, 9};
        BinarySearchTree tree = BinarySearchTreeUtils.createBinarySearchTree(integers);
        ArrayList<Integer> list = tree.getSortedArray();
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
        tree.delete(7);
        tree.delete(8);
        tree.delete(9);
        list = tree.getSortedArray();
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
