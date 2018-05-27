package lab1;

public class Main {
	
	static final Resource RESOURCE = new Resource();
	static final Thread threadOne = new Thread(new ThreadOne(RESOURCE));
	static final Thread threadTwo = new Thread(new ThreadTwo(RESOURCE));

	public static void main(String[] args) throws InterruptedException {
		threadOne.start();
		threadTwo.start();

		threadOne.join();
		threadTwo.join();
		
		System.out.println(RESOURCE.toString());
	}
}
