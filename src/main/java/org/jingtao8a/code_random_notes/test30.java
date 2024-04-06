package org.jingtao8a.code_random_notes;

import sun.reflect.generics.tree.Tree;

public class test30 {
    static class Data {
        int i;
    }
    public static int sumOfLeftLeafNodes(TreeNode<Character> root) {
        Data data = new Data();
        data.i = 0;
        preOrder(root, data);
        return data.i;
    }
    private static void preOrder(TreeNode<Character> root, Data data) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            data.i = data.i + (char)root.left.val - '0';
        }
        preOrder(root.left, data);
        preOrder(root.right, data);
    }
    public static void main(String[] args) {
        String str = "396##7##21##7##";
        Character[] characters = new Character[str.length()];
        for (int i = 0; i < str.length(); ++i) {
            characters[i] = str.charAt(i);
        }
        TreeNode<Character> root = BinaryTreeUtils.createBinaryTree(characters);
        System.out.println(sumOfLeftLeafNodes(root));
    }
}
