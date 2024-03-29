package org.jingtao8a.code_random_notes;

import java.util.Stack;

public class CustomQueue {
    private Stack<Integer> s1, s2;
    public CustomQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    public void push(Integer i) {
        s1.push(i);
    }

    public Integer pop() {
        if (s2.empty()) {
            if (s1.empty()) {
                return null;
            }
            while (!s1.empty()) {
                Integer item = s1.pop();
                s2.push(item);
            }
        }
        return s2.pop();
    }

    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
