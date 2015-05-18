package edu.hm.hafner.java2.sokoban;

import org.junit.Test;

/**
 * Tests the class {@link Pixel}.
 *
 * @author Ullrich Hafner
 */
public class PixelTest extends PointTest {
    @Override
    protected Pixel createPoint(final int x, final int y) {
        return new Pixel(x, y);
    }

    /** Verifies that the constructor does not accept negative x coordinates. */
    @Test(expected = IllegalArgumentException.class)
    public void shouldValidateYInConstructor() {
        createPoint(0, -1);
    }

    /** Verifies that the constructor does not accept negative y coordinates. */
    @Test(expected = IllegalArgumentException.class)
    public void shouldValidateXInConstructor() {
        createPoint(-1, 0);
    }

    /** Verifies that move left does not accept negative x coordinates. */
    @Test(expected = IllegalArgumentException.class)
    public void shouldValidateMoveLeft() {
        createPoint(0, 0).moveLeft();
    }

    /** Verifies that move up does not accept negative y coordinates. */
    @Test(expected = IllegalArgumentException.class)
    public void shouldValidateMoveUp() {
        createPoint(0, 0).moveUp();
    }
}