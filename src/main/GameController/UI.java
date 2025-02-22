package main.GameController;

import java.util.Scanner;

import static java.lang.System.out;

public class UI {
    public static String turnStartingOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to Roll or Display current scores?");
        System.out.println("Enter 'D' if you want to Display current scores");
        System.out.println("Enter 'R' if you want to Roll.");
        String option = scanner.next();
        return option;
    }

    public static String tuttoOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to End or Continue?");
        String tuttooption = scanner.next();
        return tuttooption;
    }

    public static String halfwayOption() {
        Scanner scanner = new Scanner(System.in);
        out.println("Would you like to End or Continue?");
        out.println("Enter 'E' if you want to End. All the valid dices in this roll will be kept. ");
        out.println("Press 'R' to continue.");
        while(!scanner.hasNext("[ER]")) {
            System.out.println("Invalid input! Please re-enter:");
            scanner.next();
        }
        String option = scanner.next();
        return option;
    }

}