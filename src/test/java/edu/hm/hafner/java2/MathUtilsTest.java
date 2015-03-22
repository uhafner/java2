package edu.hm.hafner.java2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link MathUtils}.
 *
 * @author Ullrich Hafner
 */
public class MathUtilsTest {
    /** Verifies that max works with positive and negative values. */
    @Test
    public void testMaxWithSeveralValues() {
        // Given
        MathUtils utils = new MathUtils();

        // When
        int actual = utils.max(1, -2, 0);

        // Then
        assertThat(actual).isEqualTo(1);
    }
}
