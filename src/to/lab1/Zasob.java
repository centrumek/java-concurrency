package wz;

public class Zasob {
	public static final int MAX = 1_823_978;
	public int counter = 0;
	
	public void inceremntCount() {
		for (int i = 0; i < MAX; i++) {
			counter += i;
		}
	}

	public void decrementCount() {
		for (int i = 0; i < MAX; i++) {
			counter -= i;
		}
	}
}
