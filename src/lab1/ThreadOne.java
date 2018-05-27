package lab1;

public class ThreadOne implements Runnable {

	private final long MAX = (long) 10e4;
	private Resource resource;

	public ThreadOne(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		for (long i = 0; i < MAX; i++) {
			resource.inceremntCount();
		}
	}

}
