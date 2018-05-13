package lab2;


public class Main {
	
	static final Semafor SEMAFOR = new Semafor();		
	static final Thread t1 = new Thread(new Thread1(SEMAFOR));
	static final Thread t2 = new Thread(new Thread2(SEMAFOR));
	
	
	public static void main(String[] args) throws InterruptedException {
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
	}
}
