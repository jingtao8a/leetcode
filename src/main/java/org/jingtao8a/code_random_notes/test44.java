package org.jingtao8a.code_random_notes;

public class test44 {
    //将二叉搜索树转换为累加树
    public static void convertBSTtoGreaterSumTree(TreeNode<Integer> root) {
        variantInorder(root);
    }
    public static TreeNode<Integer> pre = null;
    public static void variantInorder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        variantInorder(root.right);
        if (pre == null) {
            pre = root;
        } else {
            root.val += pre.val;
            pre = root;
        }
        variantInorder(root.left);
    }
    public static void main(String[] args) {
        Integer[] integers = new Integer[] {6, 8, 2, 0, 4, 3, 5, 7, 9};
        BinarySearchTree tree = BinarySearchTreeUtils.createBinarySearchTree(integers);
        TreeNode<Integer> root = tree.getRoot();
        BinarySearchTreeUtils.inOrder(root);
        System.out.println();
        convertBSTtoGreaterSumTree(root);
        BinarySearchTreeUtils.inOrder(root);
    }
}
