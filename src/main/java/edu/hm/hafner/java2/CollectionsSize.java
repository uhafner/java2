package edu.hm.hafner.java2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.hm.hafner.java2.sokoban.Point;

/**
 * Shows the differences between sets and lists.
 *
 * @author Ullrich Hafner
 */
public class CollectionsSize {
    public static void main(String[] args) {
        List<Point> pointsInList = new ArrayList<>();
        Set<Point> pointsInSet = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            pointsInList.add(new Point(0, 0));
            pointsInSet.add(new Point(0, 0));
        }
        System.out.println(pointsInList.size());
        System.out.println(pointsInSet.size());

        List<Integer> integersInList = new ArrayList<>();
        Set<Integer> integersInSet = new HashSet<>();
        for (int i = 5; i > 0; i--) {
            integersInList.add(i);
            integersInSet.add(i);
        }
        for (Integer integer : integersInSet) {
            System.out.println(integer);
        }
        for (Integer integer : integersInList) {
            System.out.println(integer);
        }

        integersInList.remove((Integer)5);
    }
}
