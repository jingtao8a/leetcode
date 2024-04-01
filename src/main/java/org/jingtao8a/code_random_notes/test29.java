package org.jingtao8a.code_random_notes;

import java.util.ArrayList;

public class test29 {
    public static void test1() {
        String str = "ABC##DE##F##G#H##";
        Character[] chars = new Character[str.length()];
        for (int i = 0; i < str.length(); ++i) {
            chars[i] = str.charAt(i);
        }
        TreeNode<Character> root = BinaryTreeUtils.createBinaryTree(chars);
        BinaryTreeUtils.preorder(root);
        System.out.println();
        BinaryTreeUtils.preorder_non_recursive(root);
        System.out.println();
        BinaryTreeUtils.inorder(root);
        System.out.println();
        BinaryTreeUtils.inorder_non_recursive(root);
        System.out.println();
        BinaryTreeUtils.postorder(root);
        System.out.println();
        BinaryTreeUtils.postorder_non_recursive(root);
        System.out.println();
        BinaryTreeUtils.level_traversal(root);
        System.out.println();
        ArrayList<ArrayList<Character>> res = BinaryTreeUtils.level_traversal_2(root, false);

        System.out.println("[");
        for (ArrayList<Character> list : res) {
            System.out.print("[ ");
            for (Character ch : list) {
                System.out.print(ch + " ");
            }
            System.out.println(" ]");
        }
        System.out.println("]");

        ArrayList<Character> list = BinaryTreeUtils.rightElevation(root);
        System.out.print("[");
        for(Character ch : list) {
            System.out.print(ch + " ");
        }
        System.out.println("]");


        BinaryTreeUtils.flipBinaryTree(root);
        res = BinaryTreeUtils.level_traversal_2(root, false);
        System.out.println("[");
        for (ArrayList<Character> list1 : res) {
            System.out.print("[ ");
            for (Character ch : list1) {
                System.out.print(ch + " ");
            }
            System.out.println(" ]");
        }
        System.out.println("]");
    }
    public static void test2() {
        String str = "123##4##24##3###";
        Character[] characters = new Character[str.length()];
        for (int i = 0; i < str.length(); ++i) {
            characters[i] = str.charAt(i);
        }
        TreeNode<Character> root = BinaryTreeUtils.createBinaryTree(characters);
        ArrayList<ArrayList<Character>> res = BinaryTreeUtils.level_traversal_2(root, false);

        System.out.println("[");
        for (ArrayList<Character> list : res) {
            System.out.print("[ ");
            for (Character ch : list) {
                System.out.print(ch + " ");
            }
            System.out.println(" ]");
        }
        System.out.println("]");

        System.out.println(BinaryTreeUtils.judgeSymmetry(root));


    }
    public static void main(String[] args) {
        test2();
    }
}
