package edu.hm.hafner.java2;

/**
 * Defines a lecture.
 *
 * @author Ullrich Hafner
 */
public interface Lecture {
    /**
     * Returns the name of this lecture.
     *
     * @return the name of this lecture
     */
    String getName();

    /**
     * Returns the credit points for this lecture (ECTS).
     *
     * @return the credit points for this lecture.
     */
    int getCredits();
}