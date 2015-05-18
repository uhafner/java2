package edu.hm.hafner.java2.sokoban;

/**
 * A picture element, aka Pixel. A pixel represents a point in an image with non-negative coordinates.
 */
public class Pixel extends Point {
    /**
     * Creates a new instance of {@code Pixel}.
     *
     * @param x x coordinate
     * @param y y coordinate
     */
    public Pixel(final int x, final int y) {
        super(x, y);

        if (x < 0 || y < 0) {
            throw new IllegalArgumentException(
                    "Coordinates must be not negative: " + this);
        }
    }

    @Override
    protected Pixel createPoint(final int x, final int y) {
        return new Pixel(x, y);
    }
}
