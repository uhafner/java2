package edu.hm.hafner.java2;

/**
 * Lecture to teach development of mobile applications (apps).
 *
 * @author Ullrich Hafner
 */
public class MobileApplications implements Lecture {
    @Override
    public String getName() {
        return "Mobile Anwendungen";
    }

    @Override
    public int getCredits() {
        return 0;
    }

    @Override
    public String toString() {
        return getName();
    }
}
