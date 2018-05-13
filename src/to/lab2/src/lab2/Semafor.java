package lab2;

public class Semafor {

	private boolean stan = true;
	private int czeka = 0;
	
	public synchronized void P() {
		System.out.println("thread id: " + Thread.currentThread().getId() + " Proberen | spróbuj");	
		System.out.println("beforeStan: " + stan + " beforeCzeka: " + czeka);
		if (stan) {
			stan = false;
		} else {
			try {
				czeka++;
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("afterStan: " + stan + " afterCzeka: " + czeka);
		System.out.println();
	}
	
	public synchronized void V() {
		System.out.println("thread id: " + Thread.currentThread().getId() + " Verhogen | zwieksz");
		System.out.println("beforeStan: " + stan + " beforeCzeka: " + czeka);
		if (czeka > 0) {
			notify();
			czeka--;
		} else {
			stan = true;
		}
		System.out.println("afterStan: " + stan + " afterCzeka: " + czeka);
		System.out.println();
	}
	
}
