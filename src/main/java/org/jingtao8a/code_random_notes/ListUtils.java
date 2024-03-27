package org.jingtao8a.code_random_notes;

public class ListUtils {
    public static Node createList(int[] nums) {
        Node head = new Node();
        Node tail = head;
        for (int i = 0; i < nums.length; ++i) {
            tail.next = new Node(nums[i], null);
            tail = tail.next;
        }
        return head.next;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }
}
