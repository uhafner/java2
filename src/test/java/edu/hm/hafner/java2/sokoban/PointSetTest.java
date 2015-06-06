package edu.hm.hafner.java2.sokoban;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link PointSet}.
 *
 * @author Ullrich Hafner
 */
public class PointSetTest {
    /** Verifies that the iterator works in foreach loop. */
    @Test
    public void shouldWorkInForEach() {
        // Given
        PointSet points = new PointSet();
        for (int i = 0; i < 5; i++) {
            points.add(new Point(i, i));
        }

        // When
        int position = 0;
        for (Point point : points) {
            // Then
            assertThat(point).isEqualTo(new Point(position, position));
            position++;
        }
        assertThat(position).isEqualTo(5);
    }

    /** Verifies that the set of points is empty when created. */
    @Test
    public void shouldBeEmptyWhenCreated() {
        // Given
        PointSet points = new PointSet();
        // When and then
        assertThat(points.size()).isEqualTo(0);
    }

    /** Verifies that points can be added. */
    @Test
    public void shouldStoreElements() {
        // Given
        PointSet points = new PointSet();

        // When and Then
        assertThat(points.add(new Point(1, 1))).isTrue();
        assertThat(points.size()).isEqualTo(1);
        assertThat(points.contains(new Point(1, 1))).isTrue();

        // When and Then
        assertThat(points.add(new Point(0, 0))).isTrue();
        assertThat(points.size()).isEqualTo(2);
        assertThat(points.contains(new Point(1, 1))).isTrue();
        assertThat(points.contains(new Point(0, 0))).isTrue();
    }

    /** Verifies that the order of the elements is preserved. */
    @Test
    public void shouldRetainOrderOfAddedElements() {
        // Given
        PointSet points = new PointSet();
        Point first = new Point(1, 1);
        Point second = new Point(0, 0);
        points.add(first);
        points.add(second);

        // When and Then
        assertThat(points.get(0)).isSameAs(first);
        assertThat(points.get(1)).isSameAs(second);
    }

    /** Verifies that the copy constructor creates a copy of the points array. */
    @Test
    public void shouldCopyElementsWithCopyConstructor() {
        // Given
        PointSet original = new PointSet();

        Point first = new Point(1, 1);
        Point second = new Point(0, 0);
        original.add(first);
        original.add(second);

        // When and Then
        PointSet copied = new PointSet(original);
        assertThat(copied.size()).isEqualTo(2);
        assertThat(copied.contains(first)).isTrue();
        assertThat(copied.contains(second)).isTrue();

        assertThat(copied.get(0)).isEqualTo(new Point(1, 1));
        assertThat(copied.get(1)).isEqualTo(new Point(0, 0));

        assertThat(copied.remove(first)).isTrue();
        assertThat(copied.remove(second)).isTrue();
        assertThat(copied.size()).isEqualTo(0);

        assertThat(original.size()).isEqualTo(2);
        assertThat(original.contains(first)).isTrue();
        assertThat(original.contains(second)).isTrue();
    }

    /** Verifies that points can be removed. Verifies that the first, middle and last element can be removed. */
    @Test
    public void shouldRemoveElements() {
        // Given
        PointSet points = createThreePoints();
        // When and Then
        Point first = new Point(1, 1);
        assertThat(points.remove(first)).isTrue();
        assertThat(points.size()).isEqualTo(2);
        assertThat(points.contains(first)).isFalse();

        // Given
        points = createThreePoints();
        // When and Then
        Point second = new Point(0, 0);
        assertThat(points.remove(second)).isTrue();
        assertThat(points.size()).isEqualTo(2);
        assertThat(points.contains(second)).isFalse();

        // Given
        points = createThreePoints();
        // When and Then
        Point third = new Point(2, 3);
        assertThat(points.remove(third)).isTrue();
        assertThat(points.size()).isEqualTo(2);
        assertThat(points.contains(third)).isFalse();
    }

    private PointSet createThreePoints() {
        PointSet points = new PointSet();
        Point first = new Point(1, 1);
        Point second = new Point(0, 0);
        Point third = new Point(2, 3);
        points.add(first);
        points.add(second);
        points.add(third);
        return points;
    }

    /** Verifies that the set of points identifies elements already part of the set. */
    @Test
    public void shouldFindEqualElement() {
        // Given
        PointSet points = new PointSet();
        Point point = new Point(1, 1);
        // When and then
        assertThat(points.contains(point)).isFalse();
        points.add(point);
        assertThat(points.contains(point)).isTrue();
        points.add(point);
        assertThat(points.contains(point)).isTrue();
    }

    /** Verifies that duplicate points will not be added. */
    @Test
    public void shouldAddElementOnlyOnce() {
        // Given
        PointSet points = new PointSet();

        // When and Then
        assertThat(points.add(new Point(1, 1))).isTrue();
        assertThat(points.add(new Point(1, 1))).isFalse();
        assertThat(points.size()).isEqualTo(1);
    }

    /** Verifies that an element is removed only once. */
    @Test
    public void shouldRemoveElementOnlyOnce() {
        // Given
        PointSet points = new PointSet();
        points.add(new Point(1, 1));

        // When and Then
        assertThat(points.remove(new Point(1, 1))).isTrue();
        assertThat(points.remove(new Point(1, 1))).isFalse();
        assertThat(points.size()).isEqualTo(0);
    }

    /** Verifies that {@link PointSet#toString()} is overwritten. */
    @Test
    public void shouldHaveToStringOverwritten() {
        // Given
        PointSet points = new PointSet();
        // When and Then
        assertThat(points.toString()).isEqualTo("[]");

        // Given
        points.add(new Point(1, 1));
        // When and Then
        assertThat(points.toString()).isEqualTo("[(1, 1)]");

        // Given
        points.add(new Point(2, 2));
        // When and Then
        assertThat(points.toString()).isEqualTo("[(1, 1), (2, 2)]");
    }
}