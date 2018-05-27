package lab3;

class Producer extends Thread {
	
	private static int counter = 0;

	private Buffor cubbyhole;
	private int number;

	public Producer(Buffor c, int number) {
		cubbyhole = c;
		this.number = number;
	}

	public void run() {
		while (true) {
			counter++;
			cubbyhole.put(counter);
			System.out.println("Producer #" + this.number + " put: " + counter + " buffor size: " + cubbyhole.size());
			try {
				sleep((int) (Math.random() * 800));
			} catch (InterruptedException e) {
			}
		}
	}
}
