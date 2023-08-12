package org.jingtao8a.merge_k_lists;

import org.junit.Test;

public class Test1 {
    Node createList(int[] array) {
        Node header = new Node();
        Node tail = header;
        for (int i : array) {
            tail.next = new Node(i);
            tail = tail.next;
        }
        tail.next = null;
        return header.next;
    }
    void printNode(Node res) {
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
    @Test
    public void test1() {
        Node[] lists = new Node[3];
        int[] array1 = new int[]{1, 3, 4, 7};
        int[] array2 = new int[]{5, 6, 10};
        int[] array3 = new int[]{8, 9};
        lists[0] = createList(array1);
        lists[1] = createList(array2);
        lists[2] = createList(array3);
        Node res = new Solution2().mergeKLists(lists);
        printNode(res);
    }
}
