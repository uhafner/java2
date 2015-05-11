package edu.hm.hafner.java2.counter;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link LimitedCounter}.
 *
 * @author Ullrich Hafner
 */
public class LimitedCounterTest extends OpenCounterTest {
    @Override
    protected LimitedCounter createCounter() {
        return new LimitedCounter(10); // OpenCounter test counts until 10
    }

    /** Verifies that the counter counts to 5. Subsequent calls to next will be ignored. */
    @Test
    public void shouldCountToLimitOf5() {
        int limit = 5;
        LimitedCounter counter = new LimitedCounter(limit);
        assertThat(counter.getLimit()).isEqualTo(limit);

        for (int i = 0; i < 10; i++) {
            assertThat(counter.getCount()).isEqualTo(Math.min(i, limit));

            counter.next();
        }
    }

    /** Verifies that the limit is positive. */
    @Test(expected = IllegalArgumentException.class)
    public void shouldHavePositiveLimit() {
        new LimitedCounter(0);
    }

    /** Verifies that the setter does check for the limit. */
    @Test
    public void shouldNotSetValueLargerThanLimit() {
        assertThatThrownBy(() -> {
            LimitedCounter counter = new LimitedCounter(5);
            counter.setCount(6);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Value 6 must not be larger than the limit 5.");
    }
}