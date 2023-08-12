package org.jingtao8a.merge_k_lists;

public class Solution2 {
    Node mergeTwoList(Node list1, Node list2) {
        Node header  = new Node();
        Node tail = header;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        return header.next;
    }
    public Node mergeKLists(Node[] lists) {
        Node res;
        assert(lists.length >= 2);
        res = mergeTwoList(lists[0], lists[1]);
        for (int i = 2; i < lists.length; ++i) {
            res = mergeTwoList(res, lists[i]);
        }
        return res;
    }
}
