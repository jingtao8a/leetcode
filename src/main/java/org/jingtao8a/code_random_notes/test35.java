package org.jingtao8a.code_random_notes;

public class test35 {

    public static TreeNode<Integer> mergeTrees(TreeNode<Integer> root1, TreeNode<Integer> root2) {
         if (root1 == null && root2 == null) {
             return null;
         }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    public static void preOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Integer[] array1 = new Integer[] {1, 3, 5, -1, -1, -1, 2, -1, -1};
        Integer[] array2 = new Integer[] {2, 1, -1, 4, -1, -1, 3, -1, 7, -1, -1};
        TreeNode<Integer> root1 = BinaryTreeUtils.createBinaryTree(array1);
        preOrder(root1);
        System.out.println();

        TreeNode<Integer> root2 = BinaryTreeUtils.createBinaryTree(array2);
        preOrder(root2);
        System.out.println();

        TreeNode<Integer> root = mergeTrees(root1, root2);
        preOrder(root);
    }
}
