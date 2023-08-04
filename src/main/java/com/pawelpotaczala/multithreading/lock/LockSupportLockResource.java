package com.pawelpotaczala.multithreading.lock;

public class LockSupportLockResource implements LockResource {

  private long counter = 0;

  @Override
  public void inc() {
    counter++;
  }

  @Override
  public void dec() {
    counter--;
  }

  @Override
  public long get() {
    return counter;
  }
}
