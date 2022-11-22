package TuttoGame.Logic;

import TuttoGame.GameController.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public abstract class Logic {

    protected static boolean IsValid(ArrayList<Integer> ListOfDices) {
        int occurrences;
        for (int i = 0; i < ListOfDices.size(); i++) {
            occurrences = Collections.frequency(ListOfDices, ListOfDices.get(i));
            if (ListOfDices.get(i) == 1 || ListOfDices.get(i) == 5 || occurrences >= 3) {
                return true;
            }
        }
        return false;
    }

    protected static boolean IsValidKeep(ArrayList<Integer> KeepDices) {
        if(KeepDices.size() == 1 && (KeepDices.get(0) == 1 || KeepDices.get(0) == 5)) {
            return true;
        }
        else if(KeepDices.size() == 3 && ((KeepDices.get(0) == KeepDices.get(1)) && (KeepDices.get(1) == KeepDices.get(2)))) {
            return true;
        }
        else {
            return false;
        }
    }

    protected static String TurnSartingOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to Roll or Display current scores?");
        System.out.println("Enter 'D' if you want to Display current scores; Enter 'R' if you want to Roll.");
        String option = scanner.next();
        return option;
    }

    protected static String HalfwayOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to End or Continue?");
        System.out.println("Enter 'E' if you want to End.");
        String halfwayopt = scanner.next();
        return halfwayopt;
    }

    protected static String TuttoOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You accomplished a Tutto!");
        System.out.println("Would you like to End or Continue?");
        System.out.println("Enter 'E' if you want to End.");
        String tuttooption = scanner.next();
        return tuttooption;
    }



    public abstract ArrayList<Integer> GetValidDices(Player player);

}
