package org.jingtao8a.code_random_notes;

public class test23 {
    // 实现Deque接口的集合有 ArrayDeque LinkedList 
    // 两个队列实现栈
    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();
        for (int i = 0; i < 10; ++i) {
            queue.push(i);
        }
        while (!queue.empty()) {
            System.out.println(queue.pop());
        }
    }
}
