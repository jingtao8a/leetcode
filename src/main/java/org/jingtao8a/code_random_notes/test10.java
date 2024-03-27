package org.jingtao8a.code_random_notes;

public class test10 {
    public static int computeListLength(Node node) {
        Node head = new Node();
        head.next = node;
        int length = 0;
        Node p = head;
        while (p.next != null) {
            p = p.next;
            length++;
        }
        return length;
    }
    public static Node twoListIntercetion(Node node1, Node node2) {
        int len1 = computeListLength(node1);
        int len2 = computeListLength(node2);
        Node left, right; // assump left.length < right.length;
        int diff;
        diff = Math.abs(len1 - len2);
        if (len1 < len2) {
            left = node1;
            right = node2;
        } else {
            left = node2;
            right = node1;
        }
        for (int i = 1; i <= diff; ++i) {
            right = right.next;
        }
        if (left == right) {
            return left;
        }
        while (left != null) {
            left = left.next;
            right = right.next;
            if (left == right) {
                return left;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[] num1 = new int[] {4, 1};
        int[] num2 = new int[] {5, 0, 1};
        int[] commonPart = new int[] {8, 4, 5};
        Node node1 = ListUtils.createList(num1);
        Node node2 = ListUtils.createList(num2);
        Node commonNode = ListUtils.createList(commonPart);
        Node p1 = node1, p2 = node2;
        while (p1.next != null) {
            p1 = p1.next;
        }
        while (p2.next != null) {
            p2 = p2.next;
        }
        p1.next = commonNode;
        p2.next = commonNode;

        Node node = twoListIntercetion(node1, node2);
        System.out.println(node.val);
    }
}
