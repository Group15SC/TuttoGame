package main.Logics;

import main.GameController.GameInitialization;

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

    public StraightLogic(RollDice dice) {
        super(dice);
    }

    private static boolean IsValidForStraight(ArrayList<Integer> RolledDices, ArrayList<Integer> AlreadyKeptDices) {
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

    private boolean isTuttoForStraight(ArrayList<Integer> dices){
        return(IsValidForStraight(dices, dices));
    }
    private static ArrayList<Integer> ValidInThisRollForStraight(ArrayList<Integer> rolled, ArrayList<Integer> kept){
        ArrayList<Integer> ValidDicesInThisRoll = new ArrayList<>();
        for(int dice: rolled) {
            if(!kept.contains(dice)) {
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
            Dices.DisplayDices(aPairOfDices);
            if (IsValidForStraight(aPairOfDices, keptDices)) {
                if (isTuttoForStraight(aPairOfDices)) {
                    keptDices.addAll(aPairOfDices);
                    System.out.println("Congratulations! You accomplish a Tutto!");
                    notTutto = false;
                    continueTurn = false;
                    break;
                }
                while (notTutto) {
                    // rolled dices are valid + not tutto --> keep all the valid dices and continue roll
                    keptDices.addAll(ValidInThisRollForStraight(aPairOfDices, keptDices));
                    numOfDices -= ValidInThisRollForStraight(aPairOfDices, keptDices).size();
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
