package org.jingtao8a.code_random_notes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class test31 {
    // 找树左下角之和
    private static int theValueInTheLowerLeftCornerOfTheTree(TreeNode<Character> root) {
        Queue<TreeNode<Character>> queue = new LinkedList<>();
        ArrayList<Character> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 1; i <= n; ++i) {
                TreeNode<Character> node = queue.poll();
                if (i == 1) {
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return list.get(list.size() - 1) - '0';
    }

    public static void main(String[] args) {
        String str;//= "124##357##6##";
        str = "21##3##";
        Character[] characters = new Character[str.length()];
        for (int i = 0; i < str.length(); ++i) {
            characters[i] = str.charAt(i);
        }
        TreeNode<Character> root = BinaryTreeUtils.createBinaryTree(characters);
        System.out.println(theValueInTheLowerLeftCornerOfTheTree(root));
    }
}
