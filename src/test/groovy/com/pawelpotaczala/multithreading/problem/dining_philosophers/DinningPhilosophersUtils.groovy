package com.pawelpotaczala.multithreading.problem.dining_philosophers

import java.util.concurrent.Executors
import java.util.concurrent.Semaphore
import java.util.stream.IntStream

class DinningPhilosophersUtils {

  static def checkForksFairAccess(philosophers, deviationRange) {
    def expectedFairDishes = philosophers[0].dishes
    philosophers*.dishes.every { Math.abs(it - expectedFairDishes) <= deviationRange }
  }

  static def showDishes(philosophers) {
    philosophers.collect {philosopher -> println("${philosopher.id} : ${philosopher.dishes}")}
  }

  static def await(millis) {
    Thread.currentThread().sleep(millis)
  }

  static def forceTermination(executor) {
    executor.shutdownNow()
  }

  static def buildExecutor(size) {
    Executors.newFixedThreadPool(size)
  }

  static def buildPhilosophers(size, lock) {
    def forks =       IntStream.range(0, size)
      .boxed()
      .map(ignored -> lock.newInstance())
      .toList() as List<Fork>

    def eatAllowance = new Semaphore(size - 1, true)
    IntStream.range(0, size)
      .boxed()
      .map(id -> {
        def leftFork = forks.get(id)
        def rightFork = forks.size() == id + 1 ? forks.get(0) : forks.get(id + 1);
        return new Philosopher(id, eatAllowance, leftFork, rightFork)
      })
      .toList()
  }
}
