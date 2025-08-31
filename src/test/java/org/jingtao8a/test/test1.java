package org.jingtao8a.test;

import java.util.*;
import org.junit.jupiter.api.Test;

public class test1 {
    @Test
    public void T1() {
        String str = "中国是一个很大的国家123";
        System.out.println(str);
        int l = str.length();
        System.out.println(l);
    }

    @Test
    public void T2() {
        Integer o1 = 10;
        Integer o2 = 10;
        Integer o3 = 500;
        Integer o4 = 500;
        System.out.println(o1 == o2);
        System.out.println(o3 == o4);
    }

    @Test
    public void T3() {
        huffman();
    }

    class HuffmanNode {
        int weight;
        boolean flag;
        HuffmanNode left;
        HuffmanNode right;
        HuffmanNode parent;
    }

    public void huffman() {
        int[] num = {5, 9, 12, 13, 16, 45};
        int n = num.length;
        HuffmanNode[] tree = new HuffmanNode[2 * n - 1];
        for (int i = 0; i < n; ++i) {
            tree[i] = new HuffmanNode();
            tree[i].weight = num[i];
            tree[i].flag = false;
            tree[i].left = null;
            tree[i].right = null;
            tree[i].parent = tree[i];
        }
        for (int i = n; i < 2 * n - 1; ++i) {
            int minLeftWeight = Integer.MAX_VALUE;
            int minRightWeight = Integer.MAX_VALUE;
            HuffmanNode minLeft = null;
            HuffmanNode minRight = null;
            for (int j = 0; j < i; ++j) { // 找到最小的两个node
                if (tree[j].flag) { // 已被打上标记，skip
                    continue;
                }
                if (tree[j].weight < minLeftWeight) {
                    minRight = minLeft;
                    minRightWeight = minLeftWeight;
                    minLeft = tree[j];
                    minLeftWeight = tree[j].weight;
                } else if (tree[j].weight < minRightWeight) {
                    minRight = tree[j];
                    minRightWeight = tree[j].weight;
                }
            }
            assert(minLeft != null);
            assert(minRight != null);
            assert(minLeft.weight != Integer.MAX_VALUE);
            assert(minRight.weight != Integer.MAX_VALUE);
            tree[i] = new HuffmanNode();
            minLeft.flag = true;
            minRight.flag = true;
            minLeft.parent = tree[i];
            minRight.parent = tree[i];

            tree[i].weight = minLeftWeight + minRightWeight;
            tree[i].flag = false;
            tree[i].left = minLeft;
            tree[i].right = minRight;
            tree[i].parent = tree[i];
        }
        for (int i = 0; i < n; ++i) {
            System.out.println(getCode(tree[i], n));
        }
    }

    String getCode(HuffmanNode node, int n) {
        List<Character> list = new ArrayList<>();
        while (node.parent != node) {
            HuffmanNode parent = node.parent;
            if (parent.left == node) {
                list.add('0');
            } else if (parent.right == node) {
                list.add('1');
            }
            node = parent;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; --i) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
