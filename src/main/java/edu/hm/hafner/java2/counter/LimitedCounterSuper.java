package edu.hm.hafner.java2.counter;

/**
 * A counter that counts up the a fixed limit.
 *
 * @author Ullrich Hafner
 */
public class LimitedCounterSuper extends OpenCounter {
    private final int limit;

    /**
     * Creates a new instance of {@link LimitedCounterSuper}.
     *
     * @param limit the limit this counter should count to
     */
    public LimitedCounterSuper(final int limit) {
        if (limit < 1) {
            throw new IllegalArgumentException("Limit must be a positive value: " + limit);
        }
        this.limit = limit;
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
}