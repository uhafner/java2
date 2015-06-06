package edu.hm.hafner.java2.sokoban;

import java.util.Comparator;

/**
 * Compares points by using the Euclidean distance.
 *
 * @author Ullrich Hafner
 */
public class EuclideanDistanceComparator implements Comparator<Point> {
    @Override
    public int compare(final Point o1, final Point o2) {
        return (int)(Math.signum(distance(o1) - distance(o2)));
    }

    private double distance(final Point point) {
        return Math.sqrt(
                point.getX() * point.getX() + point.getY() * point.getY());
    }
}
