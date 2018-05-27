package lab2;


public class Main {
	
	static final Counter COUNTER = new Counter();
	static final Thread t1 = new Thread(new ThreadOne(COUNTER));
	static final Thread t2 = new Thread(new ThreadTwo(COUNTER));

	public static void main(String[] args) throws InterruptedException {
		Long start = System.currentTimeMillis();
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		Long end = System.currentTimeMillis();

		System.out.println(COUNTER.toString());
		System.out.println("needed time: " + (double)(end - start)/1000 + " s");
	}
}
