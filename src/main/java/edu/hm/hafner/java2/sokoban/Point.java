package edu.hm.hafner.java2.sokoban;

import javax.annotation.concurrent.Immutable;

/**
 * A point represents a location in {@code (x,y)} coordinate space, specified in integer precision. Instances of this
 * class are immutable.
 *
 * @author Ullrich Hafner
 */
@Immutable
public class Point {
    private final int x;
    private final int y;
    private final String display;

    /**
     * Creates a new instance of {@code Point}.
     *
     * @param x x coordinate
     * @param y y coordinate
     */
    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
        display = String.format("(%d, %d)", x, y);
    }

    /**
     * Returns the x coordinate of this point.
     *
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y coordinate of this point.
     *
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Checks if this point is equal to the specified other point.
     *
     * @param other the other point
     * @return {@code true} if this point is equal to the other point, {@code false} otherwise
     */
    public boolean isEqualTo(final Point other) {
        if (other == null) {
            return false;
        }
        return other.x == x && other.y == y;
    }

    /**
     * Returns the point left of this point.
     *
     * @return the point to the left
     */
    public final Point moveLeft() {
        return createPoint(x - 1, y);
    }

    /**
     * Returns the point right of this point.
     *
     * @return the point to the right
     */
    public final Point moveRight() {
        return createPoint(x + 1, y);
    }

    /**
     * Returns the point above this point.
     *
     * @return the point above
     */
    public final Point moveUp() {
        return createPoint(x, y - 1);
    }

    /**
     * Returns the point below of this point.
     *
     * @return the point below
     */
    public final Point moveDown() {
        return createPoint(x, y + 1);
    }

    /**
     * Factory method to create a new point. All methods in this class use this method to create new instances of {@link
     * Point}. Subclasses may override with a more specific type.
     *
     * @param x x coordinate
     * @param y y coordinate
     * @return the created point
     */
    @SuppressWarnings("ParameterHidesMemberVariable")
    protected Point createPoint(final int x, final int y) { // NOCHECKSTYLE
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return display;
    }
}
