package lab2;

class Semafor {

	private boolean stan = true;
	private int czeka = 0;

	Semafor(int czeka) {
		this.czeka = czeka;
	}

	synchronized void P() throws InterruptedException {
		while (!stan) wait();
		czeka--;
		if (czeka < 1) stan = false;
	}
	
	synchronized void V() {
		stan = true;
		czeka++;
		notify();
	}
	
}
