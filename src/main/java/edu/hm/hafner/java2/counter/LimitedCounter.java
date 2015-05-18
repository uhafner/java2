package edu.hm.hafner.java2.counter;

/**
 * A counter that counts up the a fixed limit.
 *
 * @author Ullrich Hafner
 */
public class LimitedCounter extends OpenCounter {
    private final int limit;

    /**
     * Creates a new instance of {@link LimitedCounter}.
     *
     * @param limit the limit this counter should count to
     */
    public LimitedCounter(final int limit) {
        super();

        if (limit < 1) {
            throw new IllegalArgumentException("Limit must be a positive value: " + limit);
        }
        this.limit = limit;
    }

    @Override
    protected void setCount(final int count) {
        if (count > limit) {
            throw new IllegalArgumentException(String.format("Value %d must not be larger than the limit %d.", count, limit));
        }
        super.setCount(count);
    }

    /**
     * Returns the limit of this counter.
     *
     * @return the limit
     */
    public int getLimit() {
        return limit;
    }

    @Override
    public void next() {
        if (getCount() < limit) {
            super.next();
        }
    }

    /**
     * Demonstrates the usage of {@link LimitedCounter}.
     *
     * @param args not used
     */
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    public static void main(final String... args) {
        LimitedCounter counter = new LimitedCounter(5);
        for (int i = 0; i < 10; i++) {
            System.out.format("%d ", counter.getCount());
            counter.next();
        }
        System.out.println();
        counter.reset();
        System.out.printf("%d ", counter.getCount());
    }
}