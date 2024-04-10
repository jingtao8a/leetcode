package org.jingtao8a.code_random_notes;

import java.util.ArrayList;

public class test43 {
    // 修剪二叉搜索树
    public static TreeNode<Integer> trimBST(TreeNode<Integer> root, Integer low, Integer high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
    public static void main(String[] args) {
        Integer[] integers = new Integer[] {6, 8, 2, 0, 4, 3, 5, 7, 9};
        BinarySearchTree tree = BinarySearchTreeUtils.createBinarySearchTree(integers);
        ArrayList<Integer> list = tree.getSortedArray();
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
        TreeNode<Integer> root = trimBST(tree.getRoot(), 4, 8);
        BinarySearchTreeUtils.inOrder(root);
    }
}
