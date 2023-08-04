package com.pawelpotaczala.multithreading.lock;


import lombok.ToString;

/**
 * Built-in JVM synchronization support mechanism. Monitor Lock (Intrinsic Lock)
 */
@ToString
public class SynchronizedLockLockResource implements LockResource {

    private long counter = 0;

    @Override
    public synchronized void inc() {
        counter++;
    }

    @Override
    public synchronized void dec() {
        counter--;
    }

    @Override
    public long get() {
        return counter;
    }
}
