package edu.hm.hafner.java2.counter;

/**
 * A counter that counts up the a predefined limit and than restarts counting from zero.
 *
 * @author Ullrich Hafner
 */
public class LoopCounter extends LimitedCounter {
    /**
     * Creates a new instance of {@link LimitedCounter}.
     *
     * @param limit the limit this counter should count to until the counter will be reset to zero
     */
    public LoopCounter(final int limit) {
        super(limit);
    }

    @Override
    public void next() {
        if (getCount() < getLimit()) {
            super.next();
        }
        else {
            reset();
        }
    }

    /**
     * Demonstrates the usage of {@link LoopCounter}.
     *
     * @param args not used
     */
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    public static void main(final String... args) {
        LoopCounter counter = new LoopCounter(5);
        for (int i = 0; i < 10; i++) {
            System.out.format("%d ", counter.getCount());
            counter.next();
        }
        System.out.println();
        counter.reset();
        System.out.printf("%d ", counter.getCount());
    }
}