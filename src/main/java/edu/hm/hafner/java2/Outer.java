package edu.hm.hafner.java2;

import java.util.Iterator;

/**
 * Example of an iterator as nested class.
 *
 * @author Ullrich Hafner
 */
public class Outer implements Iterable<Outer> {
    @Override
    public Iterator<Outer> iterator() {
        return new Inner(this);
    }

    private static class Inner implements Iterator<Outer> {
        private final Outer outer;

        public Inner(final Outer outer) {
            this.outer = outer;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Outer next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }
}
