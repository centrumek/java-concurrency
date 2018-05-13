package lab2;

public class Thread2 implements Runnable {
	
	private Semafor semafor;
	
	public Thread2(Semafor semafor) {
		this.semafor = semafor;
	}

	@Override
	public void run() {
		while(true) {
			semafor.P();
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			semafor.V();
		}

	}

}
