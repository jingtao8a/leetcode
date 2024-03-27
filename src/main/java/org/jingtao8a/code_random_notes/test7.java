package org.jingtao8a.code_random_notes;

public class test7 {
    class Node {
        int val;
        Node next;
        Node(){}
        Node(int val, Node next) { this.val = val; this.next = next; }
    }
    private Node head;
    private int length;
    private Node tail;
    public test7() {
        this.head = new Node();
        this.length = 0;
        this.tail = head;
    }
    public int get(int index) {
        if (index + 1 > this.length) { // beyond the range
            return -1;
        }
        Node p = head;
        for (int i = 1; i <= index + 1; ++i) {
            p = p.next;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val, null);
        newNode.next = this.head.next;
        this.head.next = newNode;
        if (this.length == 0) {
            this.tail = newNode;
        }
        this.length++;
    }

    public void addAtTail(int val) {
        tail.next = new Node(val, null);
        tail = tail.next;
        this.length++;
    }

    public boolean addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return true;
        }
        if (index == this.length) {
            addAtTail(val);
            return true;
        }
        if (index > this.length) {
            return false; //not insert Node
        }
        Node p = this.head;
        for (int i = 1; i <= index; ++i) {
            p = p.next;
        }
        Node newNode = new Node(val, null);
        newNode.next = p.next;
        p.next = newNode;
        this.length++;
        return true;
    }

    public boolean deleteAtIndex(int index) {
        if (index >= this.length || index < 0) {
            return false;
        }
        boolean needToModifyTail = false;
        if (index == this.length - 1) {
            needToModifyTail = true;
        }
        Node p = this.head;
        for (int i = 1; i <= index; ++i) {
            p = p.next;
        }
        p.next = p.next.next;
        this.length--;
        if (needToModifyTail) {
            this.tail = p;
        }
        return true;
    }

    public void printListStatus() {
        Node p = this.head.next;
        while (p != null) {
            System.out.print(p.val + " -> ");
            p = p.next;
        }
        System.out.println();
        if (this.tail != this.head && this.tail != null) {
            System.out.print("tail "  + this.tail.val);
        }
        System.out.println();
        System.out.println("length " + this.length);
    }

    public static void main(String[] args) {
        test7 o = new test7();
        o.addAtTail(1);
        o.addAtTail(2);
        o.addAtTail(3);
        o.addAtTail(4);
        o.printListStatus();
        o.addAtHead(5);
        o.printListStatus();
        o.deleteAtIndex(2);
        o.printListStatus();
        o.addAtIndex(1, 4);
        o.printListStatus();
        o.addAtIndex(2, 4);
        o.printListStatus();
    }
}
