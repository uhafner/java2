package edu.hm.hafner.java2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Example to show the usage of try-catch-finally blocks.
 *
 * @author Ullrich Hafner
 */
@SuppressWarnings("all")
public class ExceptionExample {
    public static void main(String[] args) {
        goodCode();
    }

    private static void goodCode() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (scanner.hasNextInt()) {
            sum += scanner.nextInt();
        }
        System.out.println("Summe = " + sum);
    }

    private static void uglyCode() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int sum = 0;

            while (true) {
                String input = null;
                input = reader.readLine();
                sum += Integer.valueOf(input);
                System.out.println(String.format("Summe = %d", sum));
            }
        }
        catch (IOException e) {
            return;
        }
        catch (NumberFormatException e) {
            System.out.println("Bitte nur Zahlen eingeben!");
            return;
        }
    }
}
