package lab3;

import lab4.ReadersFavour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Buffor c = new Buffor();
		int  producersNumber = 2, consumerNumber = 4;
		List<Thread> consumers = new ArrayList<>(), producers = new ArrayList<>(), all = new ArrayList<>();
		for (int i = 1; i <= producersNumber; i++) {
			Thread thread = new Producer(c, i);
			consumers.add(thread);
		}
		all.addAll(consumers);
		for (int i = 1; i <= consumerNumber; i++) {
			Thread thread = new Consumer(c, i);
			producers.add(thread);
		}
		all.addAll(producers);
		Collections.shuffle(all);
		for (Thread thread : all)
			thread.start();
		for (Thread thread : all)
			thread.join();

	}

}
