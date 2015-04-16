package edu.hm.hafner.java2.counter;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link OpenCounter}.
 *
 * @author Ullrich Hafner
 */
public class OpenCounterTest {
    /**
     * Creates the counter under test. Override this method for all sub classes of {@link OpenCounter}.
     *
     * @return the SUT
     */
    protected OpenCounter createCounter() {
        return new OpenCounter();
    }

    /** Verifies that a new counter starts at zero. */
    @Test
    public void shouldStartWithZero() {
        assertThat(createCounter().getCount()).isEqualTo(0);
    }

    /** Verifies that a counter could be reset to zero. */
    @Test
    public void shouldResetToZero() {
        OpenCounter counter = createCounter();
        counter.next();
        assertThat(counter.getCount()).isEqualTo(1);
        counter.reset();
        assertThat(counter.getCount()).isEqualTo(0);
    }

    /** Verifies that a counter counts from zero to 10. */
    @Test
    public void shouldActuallyCount() {
        OpenCounter counter = createCounter();
        for (int i = 0; i < 10; i++) {
            assertThat(counter.getCount()).isEqualTo(i);

            counter.next();
        }
    }
}