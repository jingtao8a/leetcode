package org.jingtao8a.code_random_notes;

public class TreeNode<T> {
    public T val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}
    TreeNode(T val) {
        this.val = val;
    }
    TreeNode(T val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
