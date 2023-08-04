package com.pawelpotaczala.multithreading.lock;

public interface LockResource {

  void inc();

  void dec();

  long get();
}
