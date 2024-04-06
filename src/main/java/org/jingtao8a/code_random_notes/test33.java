package org.jingtao8a.code_random_notes;

public class test33 {
    public static int findIndexOfinOrder(int[] inOrder, int inStart, int inEnd, int num) {
        for (int i = inStart; i <= inEnd; ++i) {
            if (inOrder[i] == num) {
                return i;
            }
        }
        return -1;
    }
    public static TreeNode<Integer> createBinatryTree(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if (postEnd < postStart) {
            return null;
        }
        int separator = postOrder[postEnd];
        int index = findIndexOfinOrder(inOrder, inStart, inEnd, separator);
        assert(index != -1);
        TreeNode<Integer> root = new TreeNode<>();
        root.val = separator;
        root.left = createBinatryTree(inOrder, inStart, index - 1, postOrder, postStart, postStart + index - inStart - 1);
        root.right = createBinatryTree(inOrder, index + 1, inEnd, postOrder, postStart + index - inStart, postEnd - 1);
        return root;
    }

    public static void inOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int[] inOrder = new int[] {9, 3, 15, 20, 7};
        int[] postOrder = new int[] {9, 15, 7, 20, 3};
        TreeNode<Integer> root = createBinatryTree(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1);
        inOrder(root);
    }
}
