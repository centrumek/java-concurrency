package com.pawelpotaczala.multithreading.lock


import java.util.concurrent.TimeUnit

class LockResourceUtils {

  static def awaitTermination(executor, seconds) {
    executor.shutdown()
    executor.awaitTermination(seconds, TimeUnit.SECONDS)
  }

  static def buildTasks(resource, invocations) {
    [
      new Task(resource, true, invocations),
      new Task(resource, false, invocations)
    ]
  }

  static class Task implements Runnable {

    private def final resource
    private def final increment
    private def final invocations

    Task(resource, increment, invocations) {
      this.resource = resource
      this.increment = increment
      this.invocations = invocations
    }

    @Override
    void run() {
      for(int i = 0; i < invocations; i++) {
        if(increment) {
          resource.inc()
        } else {
          resource.dec()
        }
      }
    }
  }
}
