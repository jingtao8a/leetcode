package org.jingtao8a.huawei;

import java.util.concurrent.locks.ReentrantLock;

public class CustomReadWriteLock {
    private ReentrantLock write = new ReentrantLock();
    private ReentrantLock readCountLock = new ReentrantLock();
    private ReentrantLock queue = new ReentrantLock();
    private Integer readCount = 0;

    public CustomReadWriteLock() {}

    public void readLock() {
        try {
            queue.lock();
            readCountLock.lock();
            if (readCount == 0) {
                write.lock();
            }
            ++readCount;
        } finally {
            readCountLock.unlock();
            queue.lock();
        }
    }

    public void readUnlock() {
        try {
            readCountLock.lock();
            if (readCount == 1) {
                write.unlock();
            }
            --readCount;
        } finally {
            readCountLock.unlock();
        }
    }

    public void writeLock() {
        try {
            queue.lock();
            write.lock();
        } finally {
            queue.unlock();
        }

    }

    public void writeUnLock() {
        write.unlock();
    }
}
