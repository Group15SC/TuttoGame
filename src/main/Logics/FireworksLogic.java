package main.Logics;

import java.util.ArrayList;

public class FireworksLogic extends Logic {

    private ArrayList<Integer> aPairOfDices;
    private ArrayList<Integer> keptDices;
    private boolean continueTurn = true;

    public ArrayList<Integer> getKeptDices() {
        return keptDices;
    }

    public FireworksLogic(RollDice dice) {
        super(dice);
    }

    @Override
    public void getValidDices() {
        keptDices = new ArrayList<>(); // empty the kept dices
        /* FIREWORKS:
            keep throwing the dice until roll a null
            after each roll, keep all valid dices and triplets*/
        int numOfDices = 6;
        while (continueTurn){
            aPairOfDices = new ArrayList<>(); //empty the dice set
            rollAPair(numOfDices, aPairOfDices);
            Dices.displayDices(aPairOfDices);
            if(isValid(aPairOfDices)){
                // if tutto, set numOfDices = 6 and continue roll
                if(isTutto(aPairOfDices)) {
                    numOfDices = 6;
                }

                // store all the valid dices to keptDices
                keptDices.addAll(validInThisRoll(aPairOfDices));
                numOfDices -= validInThisRoll(aPairOfDices).size();
            }
            else{
                // if rolled a null, stop roll
                // All the Valid Dices have been kept in keptDices
                System.out.println("You rolled a null! Your turn is over.");
                continueTurn = false;
            }
        }
    }

}
