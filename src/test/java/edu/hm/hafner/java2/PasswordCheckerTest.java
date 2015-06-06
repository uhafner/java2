package edu.hm.hafner.java2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link PasswordChecker}.
 *
 * @author Ullrich Hafner
 */
public class PasswordCheckerTest {
    /** Verifies the checker with valid passwords. */
    @Test
    public void shouldAcceptValidPasswords() {
        assertThatPasswordIsAccepted("abcdefghij");
        assertThatPasswordIsAccepted("aAbBcCdDeE");

        assertThatPasswordIsAccepted("abcdefghijabcd");
        assertThatPasswordIsAccepted("abcdefghijklmn");
    }

    /** Verifies the checker with valid passwords. */
    @Test
    public void shouldNotAcceptInvalidPasswords() {
        assertThatPasswordIsNotAccepted("abcdefghi");
        assertThatPasswordIsNotAccepted("AbBcCdDeE");
        assertThatPasswordIsNotAccepted("abcdefghiabcdefghi");
    }

    private void assertThatPasswordIsAccepted(final String input) {
        assertThat(new PasswordChecker().isValid(input))
                .as("Password is not valid but should be").isTrue();
        assertThat(new PasswordChecker().isValid2(input))
                .as("Password is not valid but should be").isTrue();
    }

    private void assertThatPasswordIsNotAccepted(final String input) {
        assertThat(new PasswordChecker().isValid(input))
                .as("Password is valid but should not be").isFalse();
        assertThat(new PasswordChecker().isValid2(input))
                .as("Password is valid but should not be").isFalse();
    }
}
