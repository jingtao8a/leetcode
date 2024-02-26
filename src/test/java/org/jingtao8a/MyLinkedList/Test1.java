package org.jingtao8a.MyLinkedList;

import org.junit.Test;

public class Test1 {
    @Test
    public void test() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtTail(423);
        myLinkedList.addAtIndex(3, 45);
        myLinkedList.addAtIndex(1, 32);
        myLinkedList.addAtIndex(3, 123);
        myLinkedList.deleteAtIndex(0);
        myLinkedList.deleteAtIndex(4);
        myLinkedList.print();
    }
}
