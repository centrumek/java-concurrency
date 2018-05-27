package lab3;

import java.util.LinkedList;

public class Buffor {
	
	private LinkedList<Integer> linkedList = new LinkedList<Integer>();
	private int capacity = 10;
	
	public int size() {
		return linkedList.size();
	}
		   
	public synchronized void put(int value) {
		while (linkedList.size() >= capacity) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		linkedList.addFirst(value);
		notifyAll();
	}

	public synchronized int get() {
		while (linkedList.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		int value = linkedList.removeLast();
		notifyAll();
		return value;
	}

}
