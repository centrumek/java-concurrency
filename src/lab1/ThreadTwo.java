package lab1;

public class ThreadTwo implements Runnable {

	private final long MAX = (long) 10e4;
	private Resource resource;
	
	public ThreadTwo(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		for (long i = 0; i < MAX; i++) {
			resource.decrementCount();
		}
	}

}
