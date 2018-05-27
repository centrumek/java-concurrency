package lab1;

public class Resource {
	private long counter = 0;
	
	public void inceremntCount() {
		counter++;
	}

	public void decrementCount() {
		counter--;
	}

	@Override
	public String toString() {
		return "Resource{" +
				"counter=" + counter +
				'}';
	}
}
