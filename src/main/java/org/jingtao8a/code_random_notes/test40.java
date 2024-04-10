package org.jingtao8a.code_random_notes;

import java.util.ArrayList;

public class test40 {

    //二叉搜索树的最近公共祖先
    public static TreeNode<Integer> lowestCommonAncestorMethod1(TreeNode<Integer> root, Integer p, Integer q) {
        TreeNode<Integer> ancestor = root;
        while (true) {
            if (ancestor.val > p && ancestor.val > q) {
                ancestor = ancestor.left;
            } else if (ancestor.val < p && ancestor.val < q) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
    // 二叉树的最近公共祖先
    public static TreeNode<Integer> lowestCommonAncestorMethod2(TreeNode<Integer> root, Integer p, Integer q) {
        dfs(root, p, q);
        return ans;
    }
    public static TreeNode<Integer> ans = null;
    //dfs返回值定义：如果以root为根节点的子树包含p或者q，返回true，否则返回false
    public static boolean dfs(TreeNode<Integer> root, Integer p, Integer q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if (ans == null) {
            if (lson && rson || (root.val == p || root.val == q) && (lson || rson)) {
                ans = root;
            }
        }
        return lson || rson || root.val == p || root.val == q;
    }
    public static void main(String[] args) {
        Integer[] integers = new Integer[] {6, 8, 2, 0, 4, 3, 5, 8, 7, 9};
        BinarySearchTree tree = BinarySearchTreeUtils.createBinarySearchTree(integers);
//        ArrayList<Integer> list = tree.getSortedArray();
//        for (Integer i : list) {
//            System.out.print(i + " ");
//        }
        TreeNode<Integer> ans1 = lowestCommonAncestorMethod1(tree.getRoot(), 3, 5);
        System.out.println(ans1.val);
        TreeNode<Integer> ans2 = lowestCommonAncestorMethod2(tree.getRoot(), 3, 5);
        System.out.println(ans2.val);
    }
}
