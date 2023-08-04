package com.pawelpotaczala.multithreading.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReentrantReadWriteLockLockResource implements LockResource {

  private static final ReadWriteLock LOCK = new ReentrantReadWriteLock();

  private long counter = 0;

  @Override
  public void inc() {
    LOCK.writeLock().lock();
    counter++;
    LOCK.writeLock().unlock();
  }

  @Override
  public void dec() {
    LOCK.writeLock().lock();
    counter--;
    LOCK.writeLock().unlock();
  }

  @Override
  public long get() {
    return counter;
  }
}
