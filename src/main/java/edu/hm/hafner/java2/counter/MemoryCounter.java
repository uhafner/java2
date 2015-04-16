package edu.hm.hafner.java2.counter;

/**
 * A counter capable of storing and recalling its state.
 *
 * @author Ullrich Hafner
 */
public class MemoryCounter extends OpenCounter {
    private int memory = 0;

    /**
     * Stores the current value of this counter. This value can be recalled by using {@link #recall()}.
     *
     * @see #recall()
     */
    public void store() {
        memory = getCount();
    }

    /**
     * Recalls the stored value of this counter. If no value has been stored so far than the counter is reset to 0.
     *
     * @see #store()
     */
    public void recall() {
        setCount(memory);
    }
}
