package edu.hm.hafner.java2.sokoban;

import java.util.Arrays;
import java.util.Iterator;

/**
 * A collection of points that contains no duplicates. More formally, a {@link PointSet} contains no pair of elements
 * {@code p1} and {@code p2} such that {@code p1.isEqualTo(p2)}. The order of the added elements is preserved.
 *
 * @author Ullrich Hafner
 */
public class PointSet implements Iterable<Point> {
    private Point[] elements;

    /**
     * Creates a copy of the specified set of points.
     *
     * @param copy the copy to create
     */
    public PointSet(final PointSet copy) {
        elements = Arrays.copyOf(copy.elements, copy.elements.length);
    }

    /**
     * Creates an empty set of points.
     */
    public PointSet() {
        elements = new Point[0];
    }

    /**
     * Adds the specified point to the tail of this set. If this set already contains a point at the same coordinates
     * then the set will not be changed.
     *
     * @param value the point to add
     * @return {@code true} if the point has been added, {@code false} if the point was already part of this set
     */
    public boolean add(final Point value) {
        if (!contains(value)) {
            elements = Arrays.copyOf(elements, elements.length + 1);
            elements[elements.length - 1] = value;

            return true;
        }
        return false;
    }

    /**
     * Removes the specified point from this set. If this set does not contain a point at the same
     * coordinates then the set will not be changed.
     *
     * @param value the point to remove
     * @return {@code true} if the point has been removed, {@code false} if the point was not part of this set
     */
    public boolean remove(final Point value) {
        if (contains(value)) {
            Point[] removedElements = new Point[elements.length - 1];
            int position = 0;
            for (Point element : elements) {
                if (!element.equals(value)) {
                    removedElements[position] = element;
                    position++;
                }
            }
            elements = removedElements;
            return true;
        }
        return false;
    }

    /**
     * Returns the size of this set.
     *
     * @return the number of points in this set
     */
    public int size() {
        return elements.length;
    }

    /**
     * Returns the point at the given position.
     *
     * @param position the position to return
     * @return the point at the given position
     */
    public Point get(final int position) {
        return elements[position];
    }

    /**
     * Returns whether this set already contains a point that is equal to the specified point. More formally, returns
     * {@code true} if this set already contains an elements {@code p} such that {@code p.isEqualTo(point)}.
     *
     * @param point the point to check for
     * @return {@code true} if this list contains a point that is equal to the specified point
     */
    public boolean contains(final Point point) {
        for (Point element : elements) {
            if (element.equals(point)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    @Override
    public Iterator<Point> iterator() {
        return new PointIterator(this);
    }

    /**
     * Iterates over the elements of a {@link PointSet}.
     *
     * @author Ullrich Hafner
     */
    private class InnerPointIterator implements Iterator<Point> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index != size();
        }

        @Override
        public Point next() {
            Point point = get(index);
            index++;
            return point;
        }
    }
}
