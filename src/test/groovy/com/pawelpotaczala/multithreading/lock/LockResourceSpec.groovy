package com.pawelpotaczala.multithreading.lock


import spock.lang.Ignore
import spock.lang.Specification
import java.util.concurrent.Executors

import static LockResourceUtils.*

class LockResourceSpec extends Specification {

  def executor

  def setup() {
    executor = Executors.newFixedThreadPool(2)
  }

  def "Should perform synchronized lock correctly"() {
    given:
      def resource = new SynchronizedLockLockResource()
      def tasks = buildTasks(resource, 10e6)
    when:
      tasks.collect { task -> executor.submit(task) }
    then:
      awaitTermination(executor, 10)
    and:
      resource.get() == 0
  }

  def "Should perform spin lock correctly"() {
    given:
      def resource = new SpinLockLockResource()
      def tasks = buildTasks(resource, 10e6)
    when:
      tasks.collect { task -> executor.submit(task) }
    then:
      awaitTermination(executor, 10)
    and:
      resource.get() == 0
  }

  def "Should perform reentrant lock correctly"() {
    given:
      def resource = new ReentrantLockLockResource()
      def tasks = buildTasks(resource, 10e6)
    when:
      tasks.collect { task -> executor.submit(task) }
    then:
      awaitTermination(executor, 10)
    and:
      resource.get() == 0
  }

  def "Should perform reentrant read write lock correctly"() {
    given:
      def resource = new ReentrantReadWriteLockLockResource()
      def tasks = buildTasks(resource, 10e6)
    when:
      tasks.collect { task -> executor.submit(task) }
    then:
      awaitTermination(executor, 10)
    and:
      resource.get() == 0
  }

  def "Should perform stamp lock correctly"() {
    given:
      def resource = new StampedLockLockResource()
      def tasks = buildTasks(resource, 10e6)
    when:
      tasks.collect { task -> executor.submit(task) }
    then:
      awaitTermination(executor, 10)
    and:
      resource.get() == 0
  }

  @Ignore // fix lock
  def "Should perform lock support correctly"() {
    given:
      def resource = new LockSupportLockResource()
      def tasks = buildTasks(resource, 10e6)
    when:
      tasks.collect { task -> executor.submit(task) }
    then:
      awaitTermination(executor, 10)
    and:
      resource.get() == 0
  }
}