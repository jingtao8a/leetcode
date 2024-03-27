package org.jingtao8a.code_random_notes;

public class test6 {
    class Node {
        int val;
        Node next;
        Node() {}
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public Node craeteList(int[] nums) {
        Node head = new Node();
        Node tail = head;
        for (int i = 0; i < nums.length; ++i) {
            tail.next = new Node();
            tail = tail.next;
            tail.val = nums[i];
        }
        return head.next;
    }
    public void printList(Node node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public Node removeValInList(Node node, int val) {
        Node head = new Node();
        head.next = node;
        Node prev = head, next = head.next;
        while (next != null) {
            if (next.val == val) {
                prev.next = next.next;
                next = next.next;
            } else {
                prev = next;
                next = next.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        test6 o = new test6();
        int[] nums = new int[]{1,2,6,3,4,5,6};
        Node node = o.craeteList(nums);
        o.printList(node);
        System.out.println();
        node = o.removeValInList(node, 5);
        o.printList(node);
    }
}
