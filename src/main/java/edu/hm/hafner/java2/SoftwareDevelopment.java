package edu.hm.hafner.java2;

/**
 * Lecture for software development.
 *
 * @author Ullrich Hafner
 */
public class SoftwareDevelopment implements Lecture {
    private final int semester;

    /**
     * Creates a new instance of {@link SoftwareDevelopment}.
     *
     * @param semester semester (1 = winter term, 2 = summer term)
     */
    public SoftwareDevelopment(final int semester) {
        if (semester < 1 || semester > 2) {
            throw new IllegalArgumentException("Semester must be either 1 or 2: " + semester);
        }
        this.semester = semester;
    }


    @Override
    public String getName() {
        return "Softwareentwicklung " + semester;
    }

    @Override
    public int getCredits() {
        return 5;
    }

    @Override
    public String toString() {
        return getName();
    }
}
