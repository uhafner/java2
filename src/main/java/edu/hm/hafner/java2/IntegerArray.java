package edu.hm.hafner.java2;

import java.util.Arrays;

/**
 * An array of integer values.
 *
 * @author Ullrich Hafner
 */
public class IntegerArray {
    private final int[] elements;

    /**
     * Creates a new array with the specified initial elements.
     *
     * @param initialElements the initial elements of the array
     */
    public IntegerArray(final int... initialElements) {
        elements = Arrays.copyOf(initialElements, initialElements.length);
    }

    /**
     * Returns the total sum of all array elements.
     *
     * @return the sum of all array elements
     */
    public int sum() {
        int total = 0;
        for (int element : elements) {
            total += element;
        }
        return total;
    }
}
