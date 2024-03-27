package org.jingtao8a.code_random_notes;

public class test9 {

    public static test8.Node deleteNthNodeFromLast(test8.Node node, test8 o, int n) {
        test8.Node head = o.new Node();
        head.next = node;
        test8.Node left = head, right = head;
        for (int i = 1; i <= n; ++i) {
            right = right.next;
            if (right == null) {
                return null;
            }
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return head.next;
    }
    public static void main(String[] args) {
        test8 o = new test8();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        test8.Node node = o.createList(nums);
        o.printList(node);
        node = deleteNthNodeFromLast(node, o, 5);
        o.printList(node);
        node = deleteNthNodeFromLast(node, o, 4);
        o.printList(node);
    }
}
