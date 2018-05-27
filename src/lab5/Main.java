package lab5;

public class Main {

    public static final int M = 8;

    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(M);
        Consumer consumer = new Consumer(buffer);
        Producer producer = new Producer(buffer);

        Long start = System.currentTimeMillis();
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        Long end = System.currentTimeMillis();

        System.out.println("needed time: " + (double)(end - start)/1000 + " s");
    }
}
