package lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

public class WritersFavour {

    static volatile int wCounter = 0;
    static volatile int rCounter = 0;
    static Semaphore lock = new Semaphore(1);
    static Semaphore reader = new Semaphore(1);
    static Semaphore writer = new Semaphore(1);
    static Semaphore readTry = new Semaphore(1);

    static class Writer implements Runnable {
        @Override
        public void run() {
            try {
                writer.acquire();
                wCounter++;
                if(wCounter == 1) readTry.acquire();
                writer.release();
                lock.acquire();
                System.out.println(Thread.currentThread().getName() + " writing ...");
                Thread.sleep((int) (Math.random() * 800));
                System.out.println(Thread.currentThread().getName() + " stop writing ...");
                lock.release();
                writer.acquire();
                wCounter--;
                if(wCounter == 0) readTry.release();
                writer.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Reader implements Runnable {
        @Override
        public void run() {
            try {
                readTry.acquire();
                reader.acquire();
                rCounter++;
                if(rCounter == 1) lock.acquire();
                reader.release();
                readTry.release();
                System.out.println(Thread.currentThread().getName() + " reading ...");
                Thread.sleep((int) (Math.random() * 800));
                System.out.println(Thread.currentThread().getName() + " stop reading ...");
                reader.acquire();
                rCounter--;
                if(rCounter == 0) lock.release();
                reader.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Writers Favour");
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
