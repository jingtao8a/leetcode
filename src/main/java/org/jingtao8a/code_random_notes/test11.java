package org.jingtao8a.code_random_notes;

import lombok.val;

public class test11 {
    public static Node findEntranceOfCircleList(Node node) {
        Node fast = node, slow = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null) {
            return null;
        }
        fast = node;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    public static void main(String[] args) {
        int[] num = new int[]{3, 2, 0, -4};
        Node node = ListUtils.createList(num);
        Node tail = node;
        while (tail.next != null) {
            tail = tail.next;
        }
        int n = 2;
        Node p = node;
        for (int i = 0; i < n; ++i) {
            p = p.next;
        }
        tail.next = p; //闭环
//        ListUtils.printList(node);
        Node res = findEntranceOfCircleList(node);
        System.out.println(res.val);
    }
}
