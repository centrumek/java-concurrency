package wz;

public class Main {
	
	static final Zasob zasob = new Zasob();		
	static final Thread t1 = new Thread(new Thread1(zasob));
	static final Thread t2 = new Thread(new Thread2(zasob));
	
	
	public static void main(String[] args) throws InterruptedException {
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(zasob.counter);
	}
}
