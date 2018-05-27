package lab5;

import java.util.Random;

public class Producer extends Thread {

    private int maxProducts;
    private Random rand = new Random();
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
        this.maxProducts = buffer.getSize() / 2;
    }

    public void run() {
        for (int i = 0; i < 1000; ++i) {
            try {
                Thread.sleep((int) (800));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int producers = rand.nextInt(maxProducts) + 1;
            synchronized (buffer) {
                while(buffer.getAvailableSpace() == 0) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int availableSpace = Math.min(producers, buffer.getAvailableSpace());
                for(int j = 0; j < availableSpace; j++) {
                    String product = "" + i + "-" + j;
                    buffer.put(product);
                    System.out.println("Wyprodukowany " + product);
                }
                buffer.notifyAll();
            }
        }
    }
}