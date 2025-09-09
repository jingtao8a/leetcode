package org.jingtao8a.test;

import org.junit.jupiter.api.Test;


public class test4 {
    
    class Node {
        int val;
        Node next;
    }

    @Test
    void T1() {
        int n = 10;
        int k = 3;
        Node head = createList(n);
        Node ptr = head;
        while (ptr.next != ptr) {
            printList(ptr);
            for (int i = 0; i < k - 1; ++i) {
                ptr = ptr.next;
            }
            ptr.next = ptr.next.next;
        }
        System.out.println(ptr.val);
    }

    void printList(Node head) {
        System.out.print(head.val + " ");
        Node ptr = head.next;
        while (ptr != head) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    Node createList(int n) {
        if (n <= 0) {
            return null;
        }
        Node head = new Node();
        head.val = 1;
        Node tail = head;
        for (int i = 2; i <= n; ++i) {
            Node newNode = new Node();
            newNode.val = i;
            tail.next = newNode;
            tail = newNode;
        }
        tail.next = head;
        return tail;
    }
}
