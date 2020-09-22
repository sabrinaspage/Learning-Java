package chapter4.grade_report;

import java.util.Scanner;

public class GradeReport {
    public static void main(String[] args) {
        int grade, category;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a numeric grade (0 to 100): ");
        grade = scan.nextInt();

        category = grade / 10;

        System.out.print("That grade is ");

        switch (category) {
            case 10:
                System.out.println("perfect!");
                break;
            case 9:
                System.out.println("well above average.");
                break;
            case 8:
                System.out.println("above average.");
                break;
            case 7:
                System.out.println("average.");
                break;
            default:
                System.out.println("well... big oof.");
        }

        scan.close();
    }
}
