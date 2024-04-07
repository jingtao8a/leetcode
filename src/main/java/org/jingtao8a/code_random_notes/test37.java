package org.jingtao8a.code_random_notes;

public class test37 {
    public static void main(String[] args) {
        Integer[] integers = new Integer[] {5, 1, -1, -1, 4, 3, -1, -1, 6, -1, -1};
        Integer[] integers2 = new Integer[] {2, 1, -1, -1, 3, -1, -1};

        TreeNode<Integer> root = BinaryTreeUtils.createBinaryTree(integers);
        TreeNode<Integer> root2 = BinaryTreeUtils.createBinaryTree(integers2);

        System.out.println(BinarySearchTreeUtils.verifyIfBinarySearchTree(root));
        System.out.println(BinarySearchTreeUtils.verifyIfBinarySearchTree(root2));
    }
}
