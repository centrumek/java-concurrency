package com.pawelpotaczala.multithreading.problem.dining_philosophers;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrantLockFork implements Fork {

  private final Lock lock = new ReentrantLock(true);

  @SneakyThrows
  @Override
  public boolean tryAcquire() {
    return lock.tryLock(1, TimeUnit.SECONDS);
  }

  @Override
  public void release() {
    lock.unlock();
  }
}
