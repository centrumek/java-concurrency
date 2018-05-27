package lab2;

public class ThreadOne implements Runnable {

	private final long MAX = (long) 10e4;
	private Counter counter;

	public ThreadOne(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		for (long i = 0; i < MAX; i++) {
			try {
				counter.increment();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
