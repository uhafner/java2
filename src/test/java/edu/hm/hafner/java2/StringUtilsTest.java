package edu.hm.hafner.java2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link StringUtils}.
 *
 * @author Ullrich Hafner
 */
public class StringUtilsTest {
    /** Verifies that some string correctly will be reversed. */
    @Test
    public void shouldReverseStrings() {
        assertThat(StringUtils.reverse("Hallo Welt")).isEqualTo("tleW ollaH");
        assertThat(StringUtils.reverse("")).isEqualTo("");
        assertThat(StringUtils.reverse("H")).isEqualTo("H");
    }
}
