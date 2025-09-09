package org.jingtao8a.test;

import org.junit.jupiter.api.Test;

public class test5 {
    @Test
    void T1() {

    }

    class Node {
        int val;
        Node next;
    }

    Node reverseList(Node head) {
        Node newHead = new Node();
        Node ptr = head;
        while (ptr != null) {
            Node tmp = ptr.next;
            ptr.next = newHead.next;
            newHead.next = ptr;
            ptr = tmp;
        }
        return newHead.next;
    }
}
