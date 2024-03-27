package org.jingtao8a.code_random_notes;

public class test8 {
    class Node {
        int val;
        Node next;
        Node() {}
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public Node createList(int[] num) {
        Node head = new Node();
        Node tail = head;
        for (int i = 0; i < num.length; ++i) {
            tail.next = new Node(num[i], null);
            tail = tail.next;
        }
        return head.next;
    }

    public void printList(Node p) {
        while (p != null) {
            System.out.print(p.val + " -> ");
            p = p.next;
        }
        System.out.println();
    }

    public Node reverseList(Node p) {
        if (p == null) {
            return null;
        }
        Node head = new Node();
        Node prev = p, next = p.next;
        while (p != null) {
            p.next = head.next;
            head.next = p;
            p = next;
            if (next != null) {
                next = next.next;
            }
        }
        return head.next;
    }
    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3, 4, 5, 6};
        test8 o = new test8();
        Node p = o.createList(num);
        o.printList(p);
        p = o.reverseList(p);
        o.printList(p);
    }
}
