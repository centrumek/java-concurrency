package lab3;

public class Main {

	public static void main(String[] args) {
		Buffor c = new Buffor();
		Producer p1 = new Producer(c, 1);
		Consumer c1 = new Consumer(c, 1);
		Producer p2 = new Producer(c, 2);
		Producer p3 = new Producer(c, 2);
		Consumer c2 = new Consumer(c, 2);
		Consumer c3 = new Consumer(c, 3);
		p1.start();
		c1.start();
		p2.start();
		p3.start();
		c2.start();
		c3.start();

	}

}
