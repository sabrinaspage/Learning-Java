package chapter3.random_number;

import java.util.Random;

public class RandomNumbers {
    public static void main(final String[] args) {
        Random generator = new Random();
        int num1;
        float num2;

        num1 = generator.nextInt(); // from 0 to 9
        System.out.println("A random integer: " + num1);

        num1 = generator.nextInt(10) + 1;
        System.out.println("From 1 to 10: " + num1);

        num1 = generator.nextInt(20) - 10;
        System.out.println("From -10 to 9: " + num1);

        num2 = generator.nextFloat() * 6; // 0.0 to 5.999...
        num1 = (int) num2 + 1;

        System.out.println("random float * 6: " + num2); // between 0.0 and 1.0
        System.out.println("1 to 6: " + num1);
    }
}
