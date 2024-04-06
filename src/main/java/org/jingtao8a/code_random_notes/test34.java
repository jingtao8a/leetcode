package org.jingtao8a.code_random_notes;

public class test34 {
    // 最大二叉树
    public static int findIndexOfMaxNumInArray(int[] array, int start, int end) {
        int index = -1;
        int value = Integer.MIN_VALUE;
        for (int i = start; i <= end; ++i) {
            if (array[i] > value) {
                index =  i;
                value = array[index];
            }
        }
        return index;
    }
    public static TreeNode<Integer> createBinaryTree(int[] array, int start, int end) {
        if (end < start) {
            return null;
        }
        int index = findIndexOfMaxNumInArray(array, start, end);
        TreeNode<Integer> root = new TreeNode<>();
        root.val = array[index];
        root.left = createBinaryTree(array, start, index - 1);
        root.right = createBinaryTree(array, index + 1, end);
        return root;
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
        int[] array = new int[] {3, 2, 1, 6, 0, 5};
        TreeNode<Integer> root = createBinaryTree(array, 0, array.length - 1);
        preOrder(root);
    }
}
