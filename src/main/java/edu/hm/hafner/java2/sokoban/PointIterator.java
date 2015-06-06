package edu.hm.hafner.java2.sokoban;

import java.util.Iterator;

/**
 * Iterates over the elements of a {@link PointSet}.
 *
 * @author Ullrich Hafner
 */
public class PointIterator implements Iterator<Point> {
    private final PointSet points;
    private int index = 0;

    public PointIterator(final PointSet points) {
        this.points = points;
    }

    @Override
    public boolean hasNext() {
        return index != points.size();
    }

    @Override
    public Point next() {
        Point point = points.get(index);
        index++;
        return point;
    }
}
