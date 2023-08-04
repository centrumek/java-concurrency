package com.pawelpotaczala.multithreading.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  Reentrant Lock provides exclusive access, meaning only one thread at a time can acquire the lock.
 *  A thread that has already acquired the lock can re-enter the lock multiple times (reentrant behavior) without blocking itself.
 *  Other threads attempting to acquire the lock will be blocked until the lock is released by the current holder.
 */
public class ReentrantLockLockResource implements LockResource {

  private static final Lock LOCK = new ReentrantLock();

  private long counter = 0;

  @Override
  public void inc() {
    LOCK.lock();
    counter++;
    LOCK.unlock();;
  }

  @Override
  public void dec() {
    LOCK.lock();
    counter--;
    LOCK.unlock();
  }

  @Override
  public long get() {
    return counter;
  }
}
