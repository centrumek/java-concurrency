package lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ReadersFavour {

    static volatile int counter = 0;
    static Semaphore lock = new Semaphore(1);
    static Semaphore reader = new Semaphore(1);

    static class Writer implements Runnable {
        @Override
        public void run() {
            try {
                lock.acquire();
                System.out.println(Thread.currentThread().getName() + " writing ...");
                Thread.sleep((int) (Math.random() * 800));
                System.out.println(Thread.currentThread().getName() + " stop writing ...");
                lock.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Reader implements Runnable {
        @Override
        public void run() {
            try {
                reader.acquire();
                counter++;
                if (counter == 1) lock.acquire();
                reader.release();
                System.out.println(Thread.currentThread().getName() + " reading ...");
                Thread.sleep((int) (Math.random() * 800));
                System.out.println(Thread.currentThread().getName() + " stop reading ...");
                reader.acquire();
                counter--;
                if(counter == 0) lock.release();
                reader.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Readers Favour");
        int  writersNumber = 6, readersNumber = 23;
        List<Thread> writers = new ArrayList<>(), readers = new ArrayList<>(), readersAndWriters = new ArrayList<>();
        for (int i = 0; i < writersNumber; i++) {
            Thread thread = new Thread(new Writer());
            thread.setName("writer " + i);
            writers.add(thread);
        }
        readersAndWriters.addAll(writers);
        for (int i = 0; i < readersNumber; i++) {
            Thread thread = new Thread(new Reader());
            thread.setName("reader " + i);
            readers.add(thread);
        }
        readersAndWriters.addAll(readers);
        Collections.shuffle(readersAndWriters);
        Long start = System.currentTimeMillis();
        for (Thread thread : readersAndWriters)
            thread.start();
        for (Thread thread : readersAndWriters)
            thread.join();
        Long end = System.currentTimeMillis();
        System.out.println("needed time: " + (double)(end - start)/1000 + " s");
    }
}