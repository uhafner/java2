package edu.hm.hafner.java2;

/**
 * Contains useful mathematical methods that are not part of {@link Math}.
 *
 * @author Ullrich Hafner
 */
public final class SafeMathUtils {
    static final String NO_VALUES_MESSAGE = "At least one value required";

    /**
     * Returns the maximum of the specified values.
     *
     * @param elements the values to obtain the maximum from
     * @return the maximum
     * @throws IllegalArgumentException if the number of elements is 0
     */
    public static int max(final int... elements) {
        if (elements.length == 0) {
            throw new IllegalArgumentException(NO_VALUES_MESSAGE);
        }
        int maximum = elements[0];
        for (int i = 1; i < elements.length; i++) {
            maximum = Math.max(maximum, elements[i]);
        }
        return maximum;
    }

    private SafeMathUtils() {
        // prevents instantiation
    }
}
