package edu.hm.hafner.java2.counter;

/**
 * A simple counter.
 *
 * @author Ullrich Hafner
 */
public interface Counter {
    /**
     * Returns the current value of this counter.
     *
     * @return the current value
     */
    int getCount();

    /**
     * Increments the counter.
     */
    void next();
}
