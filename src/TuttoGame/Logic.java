package TuttoGame;

import TuttoGame.GameController.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public abstract class Logic {

    // check whether a list of rolled dices have valid dices to keep
    // true --> not null
    // false --> null
    protected static boolean IsValid(ArrayList<Integer> ListOfDices) {
        int occurrences;
        for (int i = 0; i < ListOfDices.size(); i++) {
            occurrences = Collections.frequency(ListOfDices, ListOfDices.get(i));
            if (ListOfDices.get(i) == 1 || ListOfDices.get(i) == 5 || occurrences != 3) {
                return true;
            }
        }
        return false;
    }

        protected static boolean IsValidKeep(ArrayList<Integer> KeepDices) {
            int occurrences;
            boolean isValid = true;
            for (int i = 0; i < KeepDices.size(); i++) {
                occurrences = Collections.frequency(KeepDices, KeepDices.get(i));
                if (KeepDices.get(i) != 1 && KeepDices.get(i) != 5 && occurrences != 3) {
                    isValid =  false;
                }
            }
            return isValid;
    }



    // [for straight card] check whether a list of rolled dices have valid dices to keep
//    protected static boolean IsValidForStraight(ArrayList<Integer> RolledDices, ArrayList<Integer> AlreadyKeptDices) {
//        if(AlreadyKeptDices.size() == 0) {
//            return true;
//        }
//        for(int Dice : RolledDices) {
//            if( Dice >= 0 && Dice <=6 && !AlreadyKeptDices.contains(Dice)) {
//                return true;
//            }
//        }
//        return false;
//    }


    // get all the valid dices in a roll
    protected static ArrayList<Integer> ValidInThisRoll( ArrayList<Integer> ListOfDices){
        int occurrences;
        ArrayList<Integer> ValidDicesInThisRoll = new ArrayList<>();
        for(int dice: ListOfDices) {
            occurrences = Collections.frequency(ListOfDices, dice);
            if(dice == 1 || dice == 5 || occurrences >=3){
                ValidDicesInThisRoll.add(dice);
            }
        }
        return ValidDicesInThisRoll;
    }






//    protected static String TurnSartingOption() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Would you like to Roll or Display current scores?");
//        System.out.println("Enter 'D' if you want to Display current scores; Enter 'R' if you want to Roll.");
//        String option = scanner.next();
//        return option;
//    }

    protected static String HalfwayOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to End or Continue?");
        System.out.println("Enter 'E' if you want to End.");
        System.out.println("Press any key to continue.");
        String halfwayopt = scanner.next();
        return halfwayopt;
    }



    public abstract ArrayList<Integer> GetValidDices();

}
