package edu.hm.hafner.java2.sokoban;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link Point}. Subclasses should override {@link #createPoint(int, int)} in order to ensure that the
 * base functionality of {@link Point} is preserved.
 */
public class PointTest {
    /**
     * Factory method to create the point under test.
     *
     * @param x x coordinate
     * @param y y coordinate
     * @return the point under test
     */
    protected Point createPoint(final int x, final int y) {
        return new Point(x, y);
    }

    /** Verifies that the coordinates of a new point are correctly set. */
    @Test
    public void shouldCreatePoint() {
        // Given
        Point point = createPoint(3, 4);

        // When and then
        assertThat(point.getX()).isEqualTo(3);
        assertThat(point.getY()).isEqualTo(4);
    }

    /** Verifies that the equals operation correctly works. */
    @Test
    public void shouldDetectEqualPoints() {
        // Given
        Point point = createPoint(3, 4);

        // When and then
        assertThat(point.isEqualTo(new Point(3, 4))).isTrue();
    }

    /** Verifies that the equals operation correctly works. */
    @Test
    public void shouldDetectNotEqualPoints() {
        // Given
        Point point = createPoint(3, 4);

        // When and then
        assertThat(point.isEqualTo(new Point(2, 4))).isFalse();
        assertThat(point.isEqualTo(new Point(4, 4))).isFalse();
        assertThat(point.isEqualTo(new Point(3, 3))).isFalse();
        assertThat(point.isEqualTo(new Point(3, 5))).isFalse();
    }

    /** Verifies that the equals operation correctly works. */
    @Test
    public void shouldDetectNullNotEqualPoints() {
        // Given
        Point point = createPoint(3, 4);

        // When and then
        assertThat(point.isEqualTo(null)).isFalse();
    }

    /** Verifies that the surrounding points are correctly computed and the SUT is not modified. */
    @Test
    public void shouldCreateNeighbors() {
        // Given
        Point point = createPoint(3, 4);

        // When and then
        assertThat(point.moveLeft().isEqualTo(new Point(2, 4))).isTrue();
        assertThat(point.moveRight().isEqualTo(new Point(4, 4))).isTrue();
        assertThat(point.moveUp().isEqualTo(new Point(3, 3))).isTrue();
        assertThat(point.moveDown().isEqualTo(new Point(3, 5))).isTrue();

        assertThat(point.isEqualTo(new Point(3, 4))).isTrue();
    }

    /** Verifies that {@link Point#toString()} is overwritten. */
    @Test
    public void shouldHaveToStringOverwritten() {
        assertThat(createPoint(4, 2).toString()).isEqualTo("(4, 2)");
    }
}