package org.jingtao8a.algorithm;

import java.util.*;
import java.util.concurrent.locks.*;
public class ProducerAndConsumer {
    ReentrantLock reentrantLock;
    Condition isEmpty;
    Condition isFull;
    Deque<Integer> queue;
    int capacity;

    ProducerAndConsumer(int capacity) {
        this.capacity = capacity;
        this.reentrantLock = new ReentrantLock();
        this.isEmpty = reentrantLock.newCondition();
        this.isFull = reentrantLock.newCondition();
        this.queue = new LinkedList<>();
    }

    public void consume() {
        try {
            reentrantLock.lock();
            while (this.queue.size() <= 0) {
                this.isEmpty.await();
            }
            System.out.println(this.queue.poll());
            this.isFull.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }

    public void produce(int val) {
        try {
            reentrantLock.lock();
            while (this.queue.size() >= this.capacity) {
                this.isFull.await();
            }
            this.queue.addLast(val);
            this.isEmpty.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer(10);
        Random random = new Random();
        Thread[] threads = new Thread[20];
        Thread[] threads2 = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
//                while (true) {
                    producerAndConsumer.produce(random.nextInt(100));
//                }
            });
        }
        for (int i = 0; i < 3; ++i) {
            threads2[i] = new Thread(()->{
               while (true) {
                   producerAndConsumer.consume();
               }
            });
        }
        for (int i = 0; i < threads.length; ++i) {
            threads[i].start();
        }
        for (int i = 0; i < threads2.length; ++i) {
            threads2[i].start();
        }
        for (int i = 0; i < threads.length; ++i) {
            threads[i].join();
        }
        for (int i = 0; i < threads2.length; ++i) {
            threads2[i].join();
        }
    }
}
