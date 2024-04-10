package org.jingtao8a.code_random_notes;

public class test42 {
    // 将有序数组转换为二叉搜索树
    public static TreeNode<Integer> convertSortedArrayToBST(Integer[] integers, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode<Integer> root = new TreeNode<>(integers[mid]);
        root.left = convertSortedArrayToBST(integers, low, mid - 1);
        root.right = convertSortedArrayToBST(integers, mid + 1, high);
        return root;
    }
    public static void main(String[] args) {
        Integer[] integers = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode<Integer> root = convertSortedArrayToBST(integers, 0, integers.length - 1);
        BinarySearchTreeUtils.preOrder(root);
        System.out.println();
        BinarySearchTreeUtils.inOrder(root);
    }
}
