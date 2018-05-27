package lab5;


import java.util.Random;

public class Consumer extends Thread {

    private int maxProducers;
    private Random rand = new Random();
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.maxProducers = buffer.getSize() / 2;
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 0; i < 1000; ++i) {
            try {
                Thread.sleep((int) (800));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int producers = rand.nextInt(maxProducers) + 1;
            synchronized (buffer) {
                while (buffer.isEmpty()) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int availableProducts = Math.min(producers, buffer.getNumberOfAvailableProducts());
                for(int j = 0; j < availableProducts; j++) {
                    System.out.println("Skonsumowany " + buffer.get());
                }
            }
        }
    }
}
