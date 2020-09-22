package chapter2;

import java.util.Scanner;

public class Countdown {
    public static void main(final String[] args) {
        float a, b;

        Scanner floatNumbers = new Scanner(System.in);
        System.out.print("a: ");
        a = floatNumbers.nextFloat();

        System.out.print("b: ");
        b = floatNumbers.nextFloat();

        System.out.println("sum: " + (a + b));
        System.out.println("difference: " + (a - b));
        System.out.println("product: " + (a * b));

        floatNumbers.close();
    }
}