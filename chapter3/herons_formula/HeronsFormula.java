package chapter3.herons_formula;

import java.util.Scanner;

public class HeronsFormula {
    public static void main(final String[] args) {
        int l1, l2, l3;
        double area, s;

        Scanner scan = new Scanner(System.in);

        System.out.println("Length 1: ");
        l1 = scan.nextInt();

        System.out.println("Length 2: ");
        l2 = scan.nextInt();

        System.out.println("Length 3: ");
        l3 = scan.nextInt();

        s = ((double)l1 + l2 + l3) / 2;
        area = Math.sqrt(s*(s-l1)*(s-l2)*(s-l3));

        System.out.println("Area using Heron's Formula: " + area);

        scan.close();

    }
}
