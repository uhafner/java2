package edu.hm.hafner.java2.sokoban;

import javax.annotation.concurrent.Immutable;
import java.util.Comparator;

/**
 * A point represents a location in {@code (x,y)} coordinate space, specified in integer precision. Instances of this
 * class are immutable.
 *
 * @author Ullrich Hafner
 */
@Immutable
public class Point implements Comparable<Point> {
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
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point point = (Point)o;

        if (x != point.x) {
            return false;
        }
        return y == point.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return display;
    }

    @Override
    public int compareTo(final Point other) {
        return (int)(Math.signum(distance(this) - distance(other)));
    }

    private double distance(final Point point) {
        return Math.sqrt(point.x * point.x + point.y * point.y);
    }

    /**
     * Compares points by using the Euclidean distance.
     *
     * @author Ullrich Hafner
     */
    public static class NestedEuclideanDistanceComparator implements Comparator<Point> {
        @Override
        public int compare(final Point o1, final Point o2) {
            return (int)(Math.signum(distance(o1) - distance(o2)));
        }

        private double distance(final Point point) {
            return Math.sqrt(
                    point.getX() * point.getX() + point.getY() * point.getY());
        }
    }
}
