package chapter5.snake_eyes;

import java.util.Random;

public class Die {
    Random generator = new Random();
    private static final int MAX = 6; // maximum face value
    private int faceValue; // current value showing on the die

    public Die() {
        faceValue = 1; // default
    }

    public int roll() {
        faceValue = (generator.nextInt() * MAX) + 1;
        return faceValue;
    }

    public void setFaceValue(int value) {
        if (value > 0 && value <= MAX) {
            faceValue = value;
        }
    }

    public int getFaceValue() {
        return faceValue;
    }

    public String toString() {
        return Integer.toString(faceValue); // bring an integer to a string
    }
}
