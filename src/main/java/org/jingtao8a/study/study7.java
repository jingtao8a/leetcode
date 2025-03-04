package org.jingtao8a.study;

public class study7 {
    class Node {
        int val;
        Node next;
        public Node() {}
        public Node(int val, Node next) { this.val = val; this.next = next;}
    }
    public Node changeList(Node list) {
        Node res = new Node();
        Node resTail = res;
        Node other = new Node();
        Node otherTail = other;
        Node p = list;
        while (p != null) {
            if (p.val % 2 != 0) {//奇数
                resTail.next = p;
                resTail = p;
            } else {
                otherTail.next = p;
                otherTail = p;
            }
            p = p.next;
        }
        resTail.next = other.next;
        return res.next;
    }
    public static void main(String[] args) {
        String str = "1+2";
        int val;
        try {
            val = Integer.valueOf(str);
        } catch (Exception e) {
            val = 3;
        }
        System.out.println(val);
    }
}
