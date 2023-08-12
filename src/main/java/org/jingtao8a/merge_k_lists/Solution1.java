package org.jingtao8a.merge_k_lists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {
    class Status implements Comparable<Status> {
        int val;
        Node ptr;
        public Status(int val, Node ptr) {
            this.val = val;
            this.ptr = ptr;
        }
        @Override
        public int compareTo(Status o) {
            return this.val - o.val;
        }
    }
    PriorityQueue<Status> priorityQueue = new PriorityQueue<>();
    public Node mergeKLists(Node[] lists) {
        for (Node list: lists) {
            assert (list != null);
            priorityQueue.offer(new Status(list.val, list));
        }
        Node header = new Node();
        Node tail = header;
        while (!priorityQueue.isEmpty()) {
            Status status = priorityQueue.poll();
            tail.next = status.ptr;
            tail = tail.next;
            if (status.ptr.next != null) {
                priorityQueue.offer(new Status(status.ptr.next.val, status.ptr.next));
            }
        }
        return header.next;
    }
}
