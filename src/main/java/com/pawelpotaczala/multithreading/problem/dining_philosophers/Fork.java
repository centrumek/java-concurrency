package com.pawelpotaczala.multithreading.problem.dining_philosophers;

public interface Fork {

  boolean tryAcquire();

  void release();
}
