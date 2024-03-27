package org.jingtao8a.hot100;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class TwoAdd {
    public static ListNode addTwoNums(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode();
        ListNode tail = resultHead;
        ListNode p1 = l1, p2 = l2;
        int carry = 0;
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            tail.next = new ListNode(sum);
            tail = tail.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p1 == null && p2 == null){
            if (carry == 1) {
                tail.next = new ListNode(1);
                tail = tail.next;
            }
            return resultHead.next;
        }

        ListNode p = null;
        if (p1 != null) {
            p = p1;
        } else if (p2 != null) {
            p = p2;
        }
        while (p != null) {
            int sum = p.val + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            tail.next = new ListNode(sum);
            tail = tail.next;
            p = p.next;
        }
        if (carry == 1) {
            tail.next = new ListNode(1);
            tail = tail.next;
        }
        return resultHead.next;
    }
    public static ListNode createList(int[] num) {
        ListNode head = new ListNode();
        ListNode tail = head;
        for (int i = 0; i < num.length; ++i) {
            tail.next = new ListNode(num[i]);
            tail = tail.next;
        }
        return head.next;
    }
    public static void printListNode(ListNode list) {
        while (list != null) {
            System.out.print(list.val);
            list = list.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] num1 = {2, 4, 3};
        int[] num2 = {5, 6, 4};
        printListNode(addTwoNums(createList(num1), createList(num2)));

        int[] num3 = {9, 9, 9, 9, 9, 9, 9};
        int[] num4 = {9, 9, 9, 9};
        printListNode(addTwoNums(createList(num3), createList(num4)));
    }
}
