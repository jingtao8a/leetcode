package org.jingtao8a.code_random_notes;

public class test36 {
    // 二叉搜索树中的搜索
    public static void main(String[] args) {
        Integer[] integers = new Integer[] {4, 2, 7, 1, 3};
        BinarySearchTree tree = BinarySearchTreeUtils.createBinarySearchTree(integers);
        TreeNode<Integer> root = tree.search(7);
        BinarySearchTreeUtils.preOrder(root);
    }
}
