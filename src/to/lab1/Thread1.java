package wz;

public class Thread1 implements Runnable {
	
	private Zasob zasob;
	
	public Thread1(Zasob zasob) {
		this.zasob = zasob;
	}

	@Override
	public void run() {
		zasob.inceremntCount();
	}

}
