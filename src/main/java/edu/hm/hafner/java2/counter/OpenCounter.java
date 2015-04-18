package edu.hm.hafner.java2.counter;

/**
 * A simple counter based on an integer value.
 *
 * @author Ullrich Hafner
 */
public class OpenCounter implements Counter {
    private int count = 0;

    @Override
    public int getCount() {
        return count;
    }

    /**
     * Resets  this counter to the specified value.
     *
     * @param count the new value
     */
    protected void setCount(final int count) {
        this.count = count;
    }

    @Override
    public void next() {
        count++;
    }

    /**
     * Resets the counter to the initial value.
     */
    public void reset() {
        count = 0;
    }

    /**
     * Demonstrates the usage of {@link OpenCounter}.
     *
     * @param args not used
     */
    public static void main(final String... args) {
        OpenCounter counter = new OpenCounter();
        for (int i = 0; i < 10; i++) {
            System.out.format("%d ", counter.getCount());
            counter.next();
        }
        System.out.println();
        counter.reset();
        System.out.printf("%d ", counter.getCount());
    }
}