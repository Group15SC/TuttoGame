package main.Logics;

import java.util.ArrayList;
import java.util.Collections;

public class StraightLogic extends Logic {

    private ArrayList<Integer> aPairOfDices;
    private ArrayList<Integer> keptDices;
    private boolean notTutto = true;
    private boolean continueTurn = true;
    private int numOfDices = 6;
    public ArrayList<Integer> getKeptDices() {
        return keptDices;
    }

    public boolean isTutto() {
        return !notTutto;
    }

    public StraightLogic(RollDice dice) {
        super(dice);
    }

    protected static boolean isValidForStraight(ArrayList<Integer> RolledDices, ArrayList<Integer> AlreadyKeptDices) {
        if(AlreadyKeptDices.size() == 0) {
            return true;
        }
        for(int Dice : RolledDices) {
            if( Dice >= 0 && Dice <=6 && !AlreadyKeptDices.contains(Dice)) {
                return true;
            }
        }
        return false;
    }

    protected static boolean isValidKeepForStraight(ArrayList<Integer> KeepDices, ArrayList<Integer> RolledDices, ArrayList<Integer> AlreadyKeptDices) {
        boolean isValid = true;
        for (int dice: KeepDices) {
            int occurrencesInInput = Collections.frequency(KeepDices, dice);
            int occurrencesRolled = Collections.frequency(RolledDices, dice);
            if (occurrencesInInput != 1 || AlreadyKeptDices.contains(dice) || occurrencesRolled < occurrencesInInput) {
                isValid =  false;
            }
        }
        return isValid;
    }

    protected boolean isTuttoForStraight(ArrayList<Integer> ValidDices, ArrayList<Integer> AlreadyKeptDices){
        return (ValidDices.size() + AlreadyKeptDices.size() == 6);
    }
    protected static ArrayList<Integer> validInThisRollForStraight(ArrayList<Integer> rolled, ArrayList<Integer> kept){
        ArrayList<Integer> ValidDicesInThisRoll = new ArrayList<>();
        for(int dice: rolled) {
            if(!kept.contains(dice) && !ValidDicesInThisRoll.contains(dice)) {
                ValidDicesInThisRoll.add(dice);
            }
        }
        return ValidDicesInThisRoll;
    }

    @Override
    public void getValidDices() {
        /* logic of Straight card, return all the valid dices
            note that the logic of valid dice is different from other cards */

        keptDices = new ArrayList<>(); // empty the kept dices
        // int numOfDices = 6;
        // I moved this assignment out of the method because it is grey when updating numOfDices
        while (continueTurn) {
            aPairOfDices = new ArrayList<>(); //empty the dice set
            rollAPair(numOfDices, aPairOfDices); //rolled a pairOfDices
            Dices.displayDices(aPairOfDices);
            if (isValidForStraight(aPairOfDices, keptDices)) {
                if (isTuttoForStraight(validInThisRollForStraight(aPairOfDices, keptDices), keptDices)) {
                    keptDices.addAll(aPairOfDices);
                    Dices.displayDices(aPairOfDices);
                    System.out.println("Congratulations! You accomplish a Tutto!");
                    notTutto = false;
                    continueTurn = false;
                    break;
                }
                while (notTutto) {
                    // rolled dices are valid + not tutto --> ask player which dice to keep and continue roll
                    ArrayList<Integer> dicesToKeep = Dices.getKeepDices();
                    while (!isValidKeepForStraight(dicesToKeep, aPairOfDices, keptDices)){
                        System.out.println("Invalid Input! Please re-enter:");
                        dicesToKeep = Dices.getKeepDices();
                    }
                    keptDices.addAll(dicesToKeep);
                    numOfDices -= dicesToKeep.size();
                    break; // break the while(notTutto) loop and continue roll left dices
                }
            } else {
                System.out.println("You rolled a null! Your turn is over.");
                keptDices = new ArrayList<>();
                continueTurn = false;
            }
        }
    }
}
