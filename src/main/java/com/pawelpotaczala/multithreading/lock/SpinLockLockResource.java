package com.pawelpotaczala.multithreading.lock;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A spinlock is a synchronization primitive that allows a thread to repeatedly check for a lock until it becomes available, instead of blocking the thread.
 * This spinning behavior can be efficient in certain scenarios where the thread is expected to wait for a short duration.
 * However, it can be wasteful if the lock is held for an extended period, as the spinning thread consumes CPU cycles.
 */
public class SpinLockLockResource implements LockResource {

  private static final AtomicBoolean LOCK = new AtomicBoolean();
  private long counter = 0;

  @Override
  public void inc() {
    while (spinAcquireLock()) {
      // Spin until the lock is acquired
    }
    counter++;
    releaseLock();
  }

  @Override
  public void dec() {
    while (spinAcquireLock()) {
      // Spin until the lock is acquired
    }
    counter--;
    releaseLock();
  }

  private boolean spinAcquireLock() {
    return !LOCK.compareAndSet(false, true);
  }

  private void releaseLock() {
    LOCK.set(false);
  }

  @Override
  public long get() {
    return counter;
  }
}
