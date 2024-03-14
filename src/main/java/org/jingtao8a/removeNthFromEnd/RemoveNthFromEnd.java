package org.jingtao8a.removeNthFromEnd;

import java.util.List;

public class RemoveNthFromEnd {
    static class ListNode {
        public int val;
        public ListNode next;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int linkLength = 0;
        ListNode p = head;
        while (p != null) {
            linkLength++;
            p = p.next;
        }
        p = head;
        for (int i = 0; i < linkLength - n - 1; ++i) {
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ListNode head = new ListNode();
        ListNode tail = head;
        for (int i = 0; i < array.length; ++i) {
            tail.next = new ListNode();
            tail = tail.next;
            tail.val = array[i];
        }
        ListNode p = head.next;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
        RemoveNthFromEnd solution = new RemoveNthFromEnd();
        ListNode res = solution.removeNthFromEnd(head.next, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

