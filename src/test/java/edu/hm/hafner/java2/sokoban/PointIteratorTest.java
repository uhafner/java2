package edu.hm.hafner.java2.sokoban;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link PointIterator}.
 *
 * @author Ullrich Hafner
 */
public class PointIteratorTest {
    /** Verifies that the iterator recognizes an empty set. */
    @Test
    public void shouldNotIterateOverEmptySet() {
        PointIterator iterator = new PointIterator(new PointSet());

        assertThat(iterator.hasNext()).isFalse();
    }

    /** Verifies that the iterator iterates over an one element set. */
    @Test
    public void shouldIterateOverOneElementSet() {
        PointSet points = new PointSet();
        points.add(new Point(0, 1));
        PointIterator iterator = new PointIterator(points);

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(new Point(0, 1));
        assertThat(iterator.hasNext()).isFalse();
    }

    /** Verifies that the iterator iterates over a two element set. */
    @Test
    public void shouldIterateOverTwoElementSet() {
        PointSet points = new PointSet();
        points.add(new Point(0, 1));
        points.add(new Point(1, 0));
        PointIterator iterator = new PointIterator(points);

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(new Point(0, 1));
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(new Point(1, 0));
        assertThat(iterator.hasNext()).isFalse();
    }
}