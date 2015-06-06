package edu.hm.hafner.java2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * TODO: document class
 *
 * @author Ullrich Hafner
 */
public class IntegerConstruction {
    public static void main(String[] args) {
        int intValue = 15;
        int otherIntValue = 15;
        Integer literal = 15;
        Integer valueOf = Integer.valueOf(15);
        Integer integer = new Integer(15);

        System.out.println(literal.equals(intValue));
        System.out.println(valueOf.equals(literal));
        System.out.println(integer.equals(valueOf));
        System.out.println(literal.equals(integer));

        System.out.println("--");

        System.out.println(intValue == otherIntValue);
        System.out.println(intValue == literal);
        System.out.println(intValue == integer);
        System.out.println(intValue == valueOf);

        System.out.println(literal == integer);
        System.out.println(literal == valueOf);

        System.out.println(valueOf == integer);


        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        Iterator<Integer> iterator = integers.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        System.out.println(sum);
    }
}
