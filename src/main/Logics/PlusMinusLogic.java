package main.Logics;

import java.util.ArrayList;

public class PlusMinusLogic extends Logic {

    private ArrayList<Integer> aPairOfDices;
    private ArrayList<Integer> keptDices;
    private boolean notTutto = true;
    private boolean continueTurn = true;

    public boolean isTutto() {
        return !notTutto;
    }
    public ArrayList<Integer> getKeptDices() {
        return keptDices;
    }

    public PlusMinusLogic(RollDice dice) {
        super(dice);
    }

    /* Try to accomplish a TUTTO and may not stop in halfway
        if the player roll a null, his/her turn is over
        the functionality of this card ends when accomplish a TUTTO */

    @Override
    public void getValidDices() {
        keptDices = new ArrayList<>(); // empty the kept dices
        int numOfDices = 6;
        while (continueTurn) {
            aPairOfDices = new ArrayList<>(); //empty the dice set
            rollAPair(numOfDices, aPairOfDices);
            Dices.displayDices(aPairOfDices);
            if (isValid(aPairOfDices)) {
                if (isTutto(aPairOfDices)) {
                    keptDices.addAll(aPairOfDices);
                    System.out.println("Congratulations! You accomplish a Tutto!");
                    notTutto = false;
                    continueTurn = false;
                    break;
                }
                numOfDices = handelNotTutto(numOfDices, notTutto);
            }
            else{
                System.out.println("You rolled a null! Your turn is over.");
                keptDices = new ArrayList<>();
                continueTurn = false;
            }
        }
    }

    public void setKeptDices(ArrayList<Integer> keptDices) {
        this.keptDices = keptDices;
    }

    public void setaPairOfDices(ArrayList<Integer> aPairOfDices) {
        this.aPairOfDices = aPairOfDices;
    }

    public int handelNotTutto(int numOfDices, boolean notTutto) {
        while (notTutto){
            // rolled dices are valid + not tutto --> keep all the valid dices and continue roll
            keptDices.addAll(validInThisRoll(aPairOfDices));
            numOfDices -= validInThisRoll(aPairOfDices).size();
            break; // break the while(notTutto) loop and continue roll left dices
        }
        return numOfDices;
    }
}
