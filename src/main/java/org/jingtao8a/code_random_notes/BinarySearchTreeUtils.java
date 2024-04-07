package org.jingtao8a.code_random_notes;

public class BinarySearchTreeUtils {
    public static BinarySearchTree createBinarySearchTree(Integer[] array) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 0; i < array.length; ++i) {
            binarySearchTree.insert(array[i]);
        }
        return binarySearchTree;
    }

    public static void preOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
