package lab2;

public class Thread1 implements Runnable {
	
	private Semafor semafor;
	
	public Thread1(Semafor semafor) {
		this.semafor = semafor;
	}

	@Override
	public void run() {
		while(true) {
			semafor.P();
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			semafor.V();
		}
	}

}
