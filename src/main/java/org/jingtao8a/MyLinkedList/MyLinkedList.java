package org.jingtao8a.MyLinkedList;

public class MyLinkedList {
        class Node {
            int val;
            Node next;
            Node() {
                this.val = -1;
                this.next = null;
            }
        }
        private Node head;
        private Node tail;
        private int length;
        public MyLinkedList() {
            this.head = new Node();
            this.tail = head;
            this.length = 0;
        }

        public int get(int index) {
            if (index + 1 > this.length) {
                return -1;
            }
            Node p = head.next;
            for (int i = 0; i < index; ++i) {
                p = p.next;
            }
            return p.val;
        }

        public void addAtHead(int val) {
            Node newNode = new Node();
            newNode.val = val;
            if (this.length == 0) {
                this.tail.next = newNode;
                this.tail = this.tail.next;
                this.length++;
                return;
            }
            newNode.next = this.head.next;
            this.head.next = newNode;
            this.length++;
        }

        public void addAtTail(int val) {
            Node newNode = new Node();
            newNode.val = val;
            this.tail.next = newNode;
            this.tail = this.tail.next;
            this.length++;
        }

        public void addAtIndex(int index, int val) {
            if (index > this.length) {
                return;
            }
            if (index == this.length) {
                addAtTail(val);
                return;
            }
            Node p = this.head;
            Node newNode = new Node();
            newNode.val = val;
            for (int i = 0; i < index; ++i) {
                p = p.next;
            }
            newNode.next = p.next;
            p.next = newNode;
            this.length++;
        }

        public void deleteAtIndex(int index) {
            if (index >= this.length) {
                return;
            }
            Node p = this.head;
            for (int i = 0; i < index; ++i) {
                p = p.next;
            }
            p.next = p.next.next;
            this.length--;
        }

        public void print() {
            Node p = this.head.next;
            for (int i = 0; i < this.length; ++i) {
                System.out.print(p.val + " ");
                p = p.next;
            }
        }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
