package org.jingtao8a.java_guide.Lock;
import java.util.concurrent.locks.*;

public class Lock {
    private static java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("thread t1");
                while (true) {
                    System.out.println("thread t1 while");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        Thread t2 = new Thread(() -> {
           try {
               Thread.sleep(1000);
               lock.lockInterruptibly();
           } catch (InterruptedException e) {
               System.out.println("thread t2");
//               throw new RuntimeException(e);
           }
        });
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main t1");
        t2.interrupt();
    }
}
