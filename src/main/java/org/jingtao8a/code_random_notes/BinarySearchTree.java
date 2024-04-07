package org.jingtao8a.code_random_notes;

public class BinarySearchTree {
    private TreeNode<Integer> root;
    public void insert(Integer num) {
        root = insertHelper(root, num);
    }

    private TreeNode<Integer> insertHelper(TreeNode<Integer> root, Integer num) {
        if (root == null) {
            return new TreeNode<>(num);
        }
        if (root.val < num) {
            root.right = insertHelper(root.right, num);
        } else {
            root.left = insertHelper(root.left, num);
        }
        return root;
    }

    public TreeNode<Integer> getRoot() {
        return root;
    }

    public TreeNode<Integer> search(Integer num) {
        return searchHelper(root, num);
    }

    private TreeNode<Integer> searchHelper(TreeNode<Integer> root, Integer num) {
        if (root == null) {
            return null;
        }
        if (root.val == num) {
            return root;
        }
        if (root.val < num) {
            return searchHelper(root.right, num);
        } else {
            return searchHelper(root.left, num);
        }
    }
}