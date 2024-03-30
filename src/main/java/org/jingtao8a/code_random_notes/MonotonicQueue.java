package org.jingtao8a.code_random_notes;

import java.util.ArrayDeque;

//单调队列
public class MonotonicQueue {
    private ArrayDeque<Integer> deque = new ArrayDeque<>();
    public Integer pop() {
        return deque.pollFirst();
    }

    public void push(Integer x) {
        while (!deque.isEmpty() && deque.peekLast() < x) {
            deque.pollLast();
        }
        deque.offerLast(x);
    }
    public Integer peek() {
        return deque.peekFirst();
    }
    public boolean isEmpty() {
        return deque.isEmpty();
    }
}
