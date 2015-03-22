package edu.hm.hafner.java2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link MathUtils}.
 *
 * @author Ullrich Hafner
 */
public class SafeMathUtilsTest {
    /** Verifies that max works with positive and negative values. */
    @Test
    public void testMaxWithSeveralValues() {
        assertThat(SafeMathUtils.max(1, -2, 0)).isEqualTo(1);
        assertThat(SafeMathUtils.max(10)).isEqualTo(10);
        assertThat(SafeMathUtils.max(0)).isEqualTo(0);
        assertThat(SafeMathUtils.max(2, 2, 0)).isEqualTo(2);
        assertThat(SafeMathUtils.max(-1, -2, -3)).isEqualTo(-1);
        assertThat(SafeMathUtils.max(-3, -2, -1)).isEqualTo(-1);
    }

    /**
     * Verifies that an exception is thrown if the parameter list is empty.
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionOnEmptyParameters() {
        SafeMathUtils.max();
    }

    /**
     * Verifies that an exception is thrown if parameter is null.
     */
    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionOnNull() {
        SafeMathUtils.max(null);
    }

    /**
     * Verifies that input parameters are validated. Uses Java 8 lambda expressions and AssertJ.
     */
    @Test
    public void shouldThrowExceptionsUsingLambdaExpressions() {
        assertThatThrownBy(() -> {
            SafeMathUtils.max();
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(SafeMathUtils.NO_VALUES_MESSAGE);
        assertThatThrownBy(() -> {
            SafeMathUtils.max(null);
        }).isInstanceOf(NullPointerException.class);
    }
}
