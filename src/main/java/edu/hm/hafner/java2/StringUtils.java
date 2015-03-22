package edu.hm.hafner.java2;

/**
 * Contains useful mathematical methods that are not part of {@link String}.
 *
 * @author Ullrich Hafner
 */
public final class StringUtils {
    /**
     * Causes this character sequence to be replaced by the reverse of
     * the sequence.
     *
     * @param input the string to reverse
     * @return the revered string
     */
    public static String reverse(final String input) {
        String reversed = "";
        for (int i = 0; i < input.length(); i++) {
            reversed = input.charAt(i) + reversed;
        }
        return reversed;
    }

    private StringUtils() {
        // prevents instantiation
    }
}
