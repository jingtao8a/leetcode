package org.jingtao8a.code_random_notes;

import java.util.*;

public class BinaryTreeUtils {
    public static TreeNode<Integer> createBinaryTree(Integer[] array) {
        Queue<Integer> queue = new LinkedList<>();
        for (Integer i : array) {
            queue.offer(i);
        }
        return createPreorder1(queue);
    }

    private static TreeNode<Integer> createPreorder1(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        Integer i = queue.poll();
        if (i != -1) {
            TreeNode<Integer> root = new TreeNode<>(i);
            root.left = createPreorder1(queue);
            root.right = createPreorder1(queue);
            return root;
        }
        return null;
    }

    public static TreeNode<Character> createBinaryTree(Character[] array) {
        Queue<Character> queue = new LinkedList<>();
        for (Character o : array) {
            queue.offer(o);
        }
        return createPreorder(queue);
    }

    //index为长度为1的数组,用于记录array的下标
    private static  TreeNode<Character> createPreorder(Queue<Character> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        Character ch = queue.poll();
        if (ch != '#') {
            TreeNode<Character> root = new TreeNode<>(ch);
            root.left = createPreorder(queue);
            root.right = createPreorder(queue);
            return root;
        }
        return null;
    }

    public static void preorder(TreeNode<Character> root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void inorder(TreeNode<Character> root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public static void postorder(TreeNode<Character> root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void preorder_non_recursive(TreeNode<Character> root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode<Character> > stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<Character> node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void inorder_non_recursive(TreeNode<Character> root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode<Character> > stack = new Stack<>();
        TreeNode<Character> p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        while (!stack.isEmpty()) {
            TreeNode<Character> node = stack.pop();
            System.out.print(node.val + " ");
            p = node.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
        }
    }

    public static void postorder_non_recursive(TreeNode<Character> root) {
        if (root == null) {
            return;
        }
        ArrayList<Character> result = new ArrayList<>();
        Stack<TreeNode<Character> > stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<Character> node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        reverse(result);
        for (int i = 0; i < result.size(); ++i) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static void level_traversal(TreeNode<Character> root) {
        Queue<TreeNode<Character> > queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode<Character> node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    // 返回 自底向上 的 层次遍历列表
    public static ArrayList<ArrayList<Character> > level_traversal_2(TreeNode<Character> root, boolean reverse) {
        ArrayList<ArrayList<Character> > res = new ArrayList<>();
        Queue<TreeNode<Character> > queue = new LinkedList<>();
        queue.offer(root);
        while (true) {
            int n = queue.size();
            if (n == 0) {
                break;
            }
            ArrayList<Character> item = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                TreeNode<Character> node = queue.poll();
                item.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(item);
        }
        if (reverse) {
            reverse(res);
        }
        return res;
    }

    public static ArrayList<Character> rightElevation(TreeNode<Character> root) {
        Queue<TreeNode<Character> > queue = new ArrayDeque<>();
        queue.offer(root);
        ArrayList<Character> res = new ArrayList<>();
        while (true) {
            int n = queue.size();
            if (n == 0) {
                break;
            }
            for (int i = 1; i <= n; ++i) {
                TreeNode<Character> node = queue.poll();
                if (i == n) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    public static <T> void  reverse(ArrayList<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            T tmp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, tmp);
            left++;
            right--;
        }
    }

    public static void flipBinaryTree(TreeNode<Character> root) {
        if (root == null) {
            return;
        }
        flipBinaryTree(root.left);
        flipBinaryTree(root.right);
        TreeNode<Character> tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public static boolean judgeSymmetry(TreeNode<Character> root) {
        if (root == null) {
            return true;
        }
        return _judegeSymmetry(root.left, root.right);
    }

    private static boolean _judegeSymmetry(TreeNode<Character> left, TreeNode<Character> right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return _judegeSymmetry(left.left, right.right) && _judegeSymmetry(left.right, right.left);
    }

    public static int getMaxDepth(TreeNode<Character> root) {
        return getMaxDepthHelper(root);
    }

    private static int getMaxDepthHelper(TreeNode<Character> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getMaxDepthHelper(root.left);
        int rightHeight = getMaxDepthHelper(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int getNodeNum(TreeNode<Character> root) {
        if (root == null) {
            return 0;
        }
        int leftNum = getNodeNum(root.left);
        int rightNum = getNodeNum(root.right);
        return leftNum + rightNum + 1;
    }

    public static boolean determineIfBalanced(TreeNode<Character> root) {
        int res = getHeight(root);
        if (res == -1) {
            return false;
        }
        return true;
    }

    private static int getHeight(TreeNode<Character> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {//不平衡
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;//平衡
    }

    public static ArrayList<ArrayDeque<Character> > allPathsInTheBinaryTree(TreeNode<Character> root) {
        if (root == null) {
            return null;
        }
        ArrayList<ArrayDeque<Character> > res = new ArrayList<>();
        ArrayDeque<Character> item = new ArrayDeque<>();
        preOrderHelper(root, item, res);
        return res;
    }

    private static void preOrderHelper(TreeNode<Character> root, ArrayDeque<Character> item, ArrayList<ArrayDeque<Character> > res) {
        if (root == null) {
            return;
        }
        item.offerLast(root.val);
        if (root.left == null && root.right == null) {
            res.add(item.clone());
            item.pollLast();
            return;
        }
        preOrderHelper(root.left, item, res);
        preOrderHelper(root.right, item, res);
        item.pollLast();
    }
}
