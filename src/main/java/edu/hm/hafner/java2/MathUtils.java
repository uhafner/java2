package edu.hm.hafner.java2;

/**
 * Contains useful mathematical methods that are not part of {@link Math}.
 *
 * @author Ullrich Hafner
 */
public class MathUtils {
    /**
     * Returns the maximum of the specified values.
     *
     * @param values the values to obtain the maximum from
     * @return the maximum
     */
    public int max(final int... values) {
        int maximum = values[0];
        for (int i = 1; i < values.length; i++) {
            maximum = Math.max(maximum, values[i]);
        }
        return maximum;
    }
}
