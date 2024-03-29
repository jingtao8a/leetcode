package org.jingtao8a.code_random_notes;


import java.util.LinkedList;
import java.util.Queue;

public class CustomStack {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();// 备份作用

    public void push(Integer x) {
        q1.offer(x);
    }

    public Integer pop() {
        if (empty()) {
            return null;
        }

        while (q1.size() > 1) {
            q2.offer(q1.poll());// 备份
        }

        Integer res = q1.poll();

        while (q2.size() > 0 ) {
            q1.offer(q2.poll());//放回q1
        }
        return res;
    }

    public Integer top() {
        Integer res = pop();
        q1.offer(res);//重新入队
        return res;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
