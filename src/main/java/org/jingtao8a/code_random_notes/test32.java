package org.jingtao8a.code_random_notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class test32 {
    public static Stack<Character> stack = new Stack<>();
    public static int sum = 0;
    public static ArrayList<List > arrayList = new ArrayList();
    public static void preOrder(TreeNode<Character> root, int target) {
        if (root == null) {
            return;
        }
        stack.push((Character) root.val);
        sum += root.val - '0';
        if (sum == target) {
            Object[] characters = stack.toArray();
            List a = Arrays.asList(characters);
            arrayList.add(a);
        }
        preOrder(root.left, target);
        preOrder(root.right, target);
        sum -= root.val - '0';
        stack.pop();
    }
    public static void main(String[] args) {
        String str = "5417##2##81##4#1##";
        Character[] characters = new Character[str.length()];
        for (int i = 0; i < str.length(); ++i) {
            characters[i] = str.charAt(i);
        }
        TreeNode<Character> root = BinaryTreeUtils.createBinaryTree(characters);
//        BinaryTreeUtils.preorder(root);
        preOrder(root, 12);
        for (List<Character> list : arrayList) {
            for (Character ch : list) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
