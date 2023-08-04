package com.pawelpotaczala.multithreading.lock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockLockResource implements LockResource {

  private static final StampedLock LOCK = new StampedLock();
  private long counter = 0;

  @Override
  public void inc() {
    var stamp = LOCK.writeLock();
    counter++;
    LOCK.unlock(stamp);
  }

  @Override
  public void dec() {
    var stamp = LOCK.writeLock();
    counter--;
    LOCK.unlock(stamp);
  }

  @Override
  public long get() {
    return counter;
  }
}
