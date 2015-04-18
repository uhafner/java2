package edu.hm.hafner.java2.counter;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link }.
 *
 * @author Ullrich Hafner
 */
public class LimitedCounterSuperTest extends OpenCounterTest {
    @Override
    protected LimitedCounterSuper createCounter() {
        return new LimitedCounterSuper(10); // OpenCounter test counts until 10
    }

    /** Verifies that the counter counts to 5. Subsequent calls to next will be ignored. */
    @Test
    public void shouldCountToLimitOf5() {
        int limit = 5;
        LimitedCounterSuper counter = new LimitedCounterSuper(limit);
        assertThat(counter.getLimit()).isEqualTo(limit);

        for (int i = 0; i < 10; i++) {
            assertThat(counter.getCount()).isEqualTo(Math.min(i, limit));

            counter.next();
        }
    }

    /** Verifies that the limit is positive. */
    @Test(expected = IllegalArgumentException.class)
    public void shouldHavePositiveLimit() {
        new LimitedCounterSuper(0);
    }
}