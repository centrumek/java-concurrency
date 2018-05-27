package lab2;

public class Counter {
    private final Semafor semafor = new Semafor(1);
    private int counter = 0;

    public void increment() throws InterruptedException {
        semafor.P();
        counter++;
        semafor.V();
    }

    public void decrement() throws InterruptedException {
        semafor.P();
        counter--;
        semafor.V();
    }

    @Override
    public String toString() {
        return "Counter{" +
                "counter=" + counter +
                '}';
    }
}
