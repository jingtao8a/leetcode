package org.jingtao8a.huawei;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerExp {

    private Deque<Integer> taskQueue;
    private Integer size;

    private ReentrantLock lock;
    private Condition empty;
    private Condition full;
    public ProducerConsumerExp(int size) {
        this.taskQueue = new ArrayDeque<>();
        this.size = size;
        this.lock = new ReentrantLock();
        this.empty = this.lock.newCondition();
        this.full = this.lock.newCondition();
    }

    public void consume() {
        try {
            lock.lock();
            while (taskQueue.isEmpty()) {
                this.empty.await();
            }
            Integer task = taskQueue.poll();
            // deal with task
            this.full.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void produce(Integer task) {
        try {
            lock.lock();
            while (taskQueue.size() == size) {
                this.full.await();
            }
            taskQueue.offer(task);
            this.empty.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
