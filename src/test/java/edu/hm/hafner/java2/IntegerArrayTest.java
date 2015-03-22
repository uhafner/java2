package edu.hm.hafner.java2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link IntegerArray}.
 *
 * @author Ullrich Hafner
 */
public class IntegerArrayTest {
    /** Verifies that the sum of an empty array is 0. */
    @Test
    public void shouldHaveSumOf0IfEmpty() {
        // Given
        IntegerArray values = new IntegerArray();

        // When
        int sum = values.sum();

        // Then
        assertThat(sum).isEqualTo(0);
    }

    /** Verifies that the sum of one element is the element itself. */
    @Test
    public void shouldSumSingleElement() {
        // Given
        IntegerArray values = new IntegerArray(5);

        // When
        int sum = values.sum();

        // Then
        assertThat(sum).isEqualTo(5);
    }

    /** Verifies that the sum of 3 elements is correct. */
    @Test
    public void shouldSumMultipleElements() {
        // Given
        IntegerArray values = new IntegerArray(1, 2, 3);

        // When
        int sum = values.sum();

        // Then
        assertThat(sum).isEqualTo(6);
    }

    /** Verifies that initial values (constructor parameter) are copied. */
    @Test
    public void shouldCopyInitialValues() {
        // Given
        int[] values = {1, 2, 3};
        IntegerArray array = new IntegerArray(values);

        // Destructive code: erase array content
        values[0] = 0;
        values[1] = 0;
        values[2] = 0;

        // When
        int sum = array.sum();

        // Then
        assertThat(sum).isEqualTo(6);
    }

}