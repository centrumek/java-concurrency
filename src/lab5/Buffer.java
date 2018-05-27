package lab5;

import java.util.LinkedList;

public class Buffer {

    private LinkedList<String> list = new LinkedList<>();
    private int maxSize;

    public Buffer(int M) {
        this.maxSize = 2*M;
    }

    public void put(String i) {
        if(list.size() >= maxSize) throw new RuntimeException("Buffer size exceeded: " + list.size());
        list.addLast(i);
    }

    public String get() {
        String ret = list.getFirst();
        list.removeFirst();
        return ret;
    }

    public int getAvailableSpace() {
        return maxSize-list.size();
    }

    public int getSize() {
        return this.maxSize;
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int getNumberOfAvailableProducts() {
        return list.size();
    }
}
