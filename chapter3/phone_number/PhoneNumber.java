package chapter3.phone_number;

import java.util.Random;

public class PhoneNumber {
    public static void main(String[] args){
        Random generator = new Random();

        int first = generator.nextInt(1000) + 100;
        int second = generator.nextInt(742) + 100;
        int third = generator.nextInt(10000) + 1000;

        System.out.printf("%d-%d-%d", first, second, third);
    }
}
