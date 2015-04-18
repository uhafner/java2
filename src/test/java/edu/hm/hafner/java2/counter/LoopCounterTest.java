package edu.hm.hafner.java2.counter;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link }.
 *
 * @author Ullrich Hafner
 */
public class LoopCounterTest extends OpenCounterTest {
    @Override
    protected LoopCounter createCounter() {
        return new LoopCounter(10); // OpenCounter test counts until 10
    }

    /** Verifies that the counter counts to 5 and then resets to 0.  */
    @Test
    public void shouldCountToLimitOf5() {
        int limit = 5;
        LimitedCounter counter = new LoopCounter(limit);
        assertThat(counter.getLimit()).isEqualTo(limit);

        for (int i = 0; i < 10; i++) {
            assertThat(counter.getCount()).isEqualTo(i % (limit + 1));

            counter.next();
        }
    }

    /** Verifies that the limit is positive. */
    @Test(expected = IllegalArgumentException.class)
    public void shouldHavePositiveLimit() {
        new LimitedCounter(0);
    }
}