package wz;

public class Thread2 implements Runnable {
	
	private Zasob zasob;
	
	public Thread2(Zasob zasob) {
		this.zasob = zasob;
	}

	@Override
	public void run() {
		zasob.decrementCount();
	}

}
