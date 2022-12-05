package main.Logics;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Logic {

    // check whether a list of rolled dices have valid dices to keep
    // true --> not null
    // false --> null
    protected RollDice dice;
    public Logic(RollDice dice) {
        this.dice = dice;
    }
    protected static boolean isValid(ArrayList<Integer> ListOfDices) {
        int occurrences;
        for (int i = 0; i < ListOfDices.size(); i++) {
            occurrences = Collections.frequency(ListOfDices, ListOfDices.get(i));
            if (ListOfDices.get(i) == 1 || ListOfDices.get(i) == 5 || occurrences >= 3) {
                return true;
            }
        }
        return false;
    }

    // roll a specific number of dices
    protected void rollAPair(int num, ArrayList<Integer> aPairOfDices){
        for(int i=0; i<num; i++){
            aPairOfDices.add(dice.rollDice());
        }
    }

    // check if a list of dieces that user choose is ok to keep according to rolled dice
    protected static boolean isValidKeep(ArrayList<Integer> KeepDices, ArrayList<Integer> RolledDices) {
        boolean isValid = true;
        for (int dice: KeepDices) {
            int occurrencesInInput = Collections.frequency(KeepDices, dice);
            int occurrencesActual = Collections.frequency(RolledDices, dice);
            if ((dice != 1 && dice != 5 && occurrencesInInput != 3) || (occurrencesActual < occurrencesInInput)) {
                isValid =  false;
            }
        }
        return isValid;
    }

    // get all the valid dices in a roll
    protected static ArrayList<Integer> validInThisRoll(ArrayList<Integer> ListOfDices){
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

//    protected void setDice(RollDices dice) {
//        this.dice = dice;
//    }

    protected boolean isTutto(ArrayList<Integer> dices){
        return(isValidKeep(dices, dices));
    }

    public abstract void getValidDices();
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






//    protected static String TurnSartingOption() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Would you like to Roll or Display current scores?");
//        System.out.println("Enter 'D' if you want to Display current scores; Enter 'R' if you want to Roll.");
//        String option = scanner.next();
//        return option;
//    }