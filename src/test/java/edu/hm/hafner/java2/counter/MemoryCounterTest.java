package edu.hm.hafner.java2.counter;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link MemoryCounter}.
 *
 * @author Ullrich Hafner
 */
public class MemoryCounterTest extends OpenCounterTest {
    @Override
    protected MemoryCounter createCounter() {
        return new MemoryCounter();
    }

    /** Verifies that the counter is set to zero after recall if store has not been called. */
    @Test
    public void shouldRecallToZeroIfStoreHasNotBeenUsed() {
        MemoryCounter counter = createCounter();
        int steps = 5;
        next(counter, steps);
        assertThat(counter.getCount()).isEqualTo(steps);

        counter.recall();
        assertThat(counter.getCount()).isEqualTo(0);
    }

    /**
     * Stores the counter value at 5 and counts until 10 is reached. Then the counter value is recalled to 5.
     */
    @Test
    public void shouldStoreAndRecallCorrectly() {
        MemoryCounter counter = createCounter();
        int steps = 5;
        next(counter, steps);
        counter.store();
        next(counter, steps);
        assertThat(counter.getCount()).isEqualTo(2 * steps);
        counter.recall();
        assertThat(counter.getCount()).isEqualTo(steps);
    }

    private void next(final MemoryCounter counter, final int steps) {
        for (int i = 0; i < steps; i++) {
            counter.next();
        }
    }
}