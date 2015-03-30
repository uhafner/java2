package edu.hm.hafner.java2;

/**
 * Shows the results of polymorphic calls to {@link Lecture#getName()}.
 *
 * @author Ullrich Hafner
 */
public class LecturesExample {
    public static void main(final String[] args) {
        Lecture lecture;
        lecture = new MobileApplications();
        System.out.println(
                lecture.getName()); // Mobile Anwendungen
        lecture = new SoftwareDevelopment(1);
        System.out.println(
                lecture.getName()); // Softwareentwicklung
    }
}
