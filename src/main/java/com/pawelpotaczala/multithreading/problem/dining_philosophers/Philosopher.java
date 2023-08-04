package com.pawelpotaczala.multithreading.problem.dining_philosophers;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
public class Philosopher implements Runnable {

  private final ThreadLocalRandom random = ThreadLocalRandom.current();
  private final int id;
  private final Semaphore eatAllowance;
  private final Fork leftFork;
  private final Fork rightFork;
  private int dishes;

  public void think() {
    log.debug("I'm thinking");
  }

  public void eat() {
    log.debug("I'm eating");
    await();
    dishes++;
  }

  public int getDishes() {
    return dishes;
  }

  public int getId() {
    return id;
  }

  @SneakyThrows
  private void await() {
    Thread.sleep(random.nextInt(50));
  }

  //@SneakyThrows
  @Override
  public void run() {
    while (true) {
      think();

     // eatAllowance.acquire(2);
        try {
          log.trace("eat allowance acquired");
          if (leftFork.tryAcquire()) {
            try {
              log.trace("left fork acquired");
              if (rightFork.tryAcquire()) {
                try {
                  log.trace("right fork acquired");
                  eat();
                } finally {
                  rightFork.release();
                  log.trace("right fork released");
                }
              }
            } finally {
              leftFork.release();
              log.trace("left fork released");
            }
          }
        } finally {
         // eatAllowance.release(2);
          log.trace("eat allowance Released");
        }

    }
  }
}
