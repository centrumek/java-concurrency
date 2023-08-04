package com.pawelpotaczala.multithreading.problem.dining_philosophers

import spock.lang.Specification

import java.util.concurrent.Executors
import java.util.concurrent.Semaphore
import java.util.stream.IntStream

import static com.pawelpotaczala.multithreading.problem.dining_philosophers.DinningPhilosophersUtils.*


class DiningPhilosophersSpec extends Specification {

  def "Should pass dining philosophers fair access to forks"() {
    given:
      def size = 20
      def executor = buildExecutor(size)
      def philosophers = buildPhilosophers(size, ReentrantLockFork.class)
    when:
      philosophers.forEach(executor::submit)

    and:
      await(2000)
      forceTermination(executor)
      showDishes(philosophers)

    then:
      checkForksFairAccess(philosophers, 4)
  }

  def "Should pass dining philosophers fair access to forks"() {
    given:
      def size = 200
      def result = false

    when:
      for(int i = 0; i < 20; i++) {
        def executor = buildExecutor(size)
        def philosophers = buildPhilosophers(size, ReentrantLockFork.class)
        philosophers.forEach(executor::submit)
        await(1000)
        showDishes(philosophers)
        forceTermination(executor)
        result = result || checkForksFairAccess(philosophers, 2)
      }
     then:
      result
  }
}