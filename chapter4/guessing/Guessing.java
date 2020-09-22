package chapter4.guessing;

import java.util.Random;
import java.util.Scanner;

public class Guessing {
    public static void main(String[] args) {
        final int MAX = 10;
        int answer, guess;

        Scanner scan = new Scanner(System.in);
        Random generator = new Random();

        answer = generator.nextInt(MAX) + 1; // number btwn 1 and MAX

        System.out.print("I'm thinking of a number between 1 and " + MAX + ". Guess what it is: ");
        guess = scan.nextInt();

        if (guess == answer) {
            System.out.print("Correct!");
        } else {
            System.out.println("Wrong. The answer was: " + answer);
        }

        scan.close();
    }
}
