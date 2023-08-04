## Concurrent Programming in Java

“_In programming, concurrency is the composition of independently executing processes, while parallelism is the
simultaneous execution of (possibly related) computations. Concurrency is about dealing with lots of things at once.
Parallelism is about doing lots of things at once._”

Source: blog.golang.org

- https://en.wikipedia.org/wiki/Parallel_computing
- https://en.wikipedia.org/wiki/Concurrent_computing
- https://medium.com/@peterlee2068/concurrency-and-parallelism-in-java-f625bc9b0ca4
- https://kwahome.medium.com/concurrency-is-not-parallelism-a5451d1cde8d
- https://jenkov.com/tutorials/java-concurrency/index.html
- https://subscription.packtpub.com/book/programming/9781785886126/1/ch01lvl1sec11/java-concurrency-api
- https://unal40.medium.com/java-concurrency-api-3adba4a14726
- https://blog.devgenius.io/eight-best-practices-in-java-concurrency-java-developer-should-know-bab52dabce14
- https://piotrminkowski.com/2023/04/30/concurrency-with-kafka-and-spring-boot/

#### Unstructured vs Structured concurrency

- https://en.wikipedia.org/wiki/Structured_concurrency
- https://cr.openjdk.org/~rpressler/loom/loom/sol1_part1.html
- https://blog.softwaremill.com/prototype-loom-based-concurrency-api-for-scala-softwaremill-5990361c6e9a

### Concurrency Control

The main challenge in designing concurrent programs is concurrency control: ensuring the correct sequencing of the
interactions or communications between different computational executions, and coordinating access to resources that are
shared among executions.

- https://en.wikipedia.org/wiki/Concurrency_control
- https://en.wikipedia.org/wiki/Race_condition
- https://en.wikipedia.org/wiki/Critical_section
- https://en.wikipedia.org/wiki/Mutual_exclusion
- https://en.wikipedia.org/wiki/Lock_(computer_science)
- https://en.wikipedia.org/wiki/Synchronization_(computer_science)
- https://thedatafreak.medium.com/concurrency-control-the-heart-of-transactions-bdae84682711
- https://www.baeldung.com/java-volatile-vs-atomic

### Consistency Models

Concurrent programming languages and multiprocessor programs must have a consistency model (also known as a memory
model). The consistency model defines rules for how operations
on [computer data storage](https://en.wikipedia.org/wiki/Computer_data_storage) occur and how results are produced.

- https://en.wikipedia.org/wiki/Consistency_model

### Concurrency Patterns

- https://en.wikipedia.org/wiki/Concurrency_pattern

### I/O operations

- https://learn.microsoft.com/en-us/azure/architecture/antipatterns/synchronous-io/
- https://en.wikipedia.org/wiki/Non-blocking_algorithm
- https://en.wikipedia.org/wiki/Asynchronous_I/O
- https://www.geeksforgeeks.org/difference-between-asynchronous-and-non-blocking/