package main;

import java.util.Scanner;

public class Utils {
    public static String TurnStartingOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to Roll or Display current scores?");
        System.out.println("Enter 'D' if you want to Display current scores");
        System.out.println("Enter 'R' if you want to Roll.");
        String option = scanner.next();
        return option;
    }

    public static String TuttoOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You accomplished a Tutto!");
        System.out.println("Would you like to End or Continue?");
        System.out.println("Enter 'E' if you want to End.");
        String tuttooption = scanner.next();
        return tuttooption;
    }

}
