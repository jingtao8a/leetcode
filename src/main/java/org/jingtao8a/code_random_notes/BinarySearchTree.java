package org.jingtao8a.code_random_notes;

import java.util.ArrayList;

public class BinarySearchTree {
    private TreeNode<Integer> root;


    public ArrayList<Integer> getSortedArray() {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(list, root);
        return list;
    }

    private void inOrder(ArrayList<Integer> list, TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        inOrder(list, root.left);
        list.add(root.val);
        inOrder(list, root.right);
    }

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

    public void delete(Integer num) {
        root = deleteHelper(root, num);
    }

    private TreeNode<Integer> deleteHelper(TreeNode<Integer> root, Integer num) {
        if (root == null) {
            return null;
        }
        if (root.val == num) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left != null) {
                TreeNode<Integer> p = root.left;
                while (p.right != null) {
                    p = p.right;
                }
                Integer tmp = p.val;
                p.val = root.val;
                root.val = tmp;
                root.left = deleteHelper(root.left, num);
            } else {
                TreeNode<Integer> p = root.right;
                while (p.left != null) {
                    p = p.left;
                }
                Integer tmp = p.val;
                p.val = root.val;
                root.val = tmp;
                root.right = deleteHelper(root.right, num);
            }
        } else if (root.val < num) {
            root.right = deleteHelper(root.right, num);
        } else {
            root.left = deleteHelper(root.left, num);
        }
        return root;
    }
}
