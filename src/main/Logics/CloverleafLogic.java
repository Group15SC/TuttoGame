package main.Logics;

import main.GameController.GameInitialization;

import java.util.ArrayList;

public class CloverleafLogic extends Logic {

    private ArrayList<Integer> aPairOfDices;
    private ArrayList<Integer> keptDices;
    private boolean notTutto = true;
    private boolean continueTurn = true;

    public ArrayList<Integer> getKeptDices() {
        return keptDices;
    }

    public CloverleafLogic(RollDice dice) {
        super(dice);
    }

    /* Try to accomplish two TUTTO
            And Player may not stop before accomplishing two tutto */

    @Override
    public void getValidDices() {
        keptDices = new ArrayList<>(); // empty the kept dices
        int numOfDices = 6;
        while (continueTurn) {
            aPairOfDices = new ArrayList<>(); //empty the dice set
            rollAPair(numOfDices, aPairOfDices);
            Dices.DisplayDices(aPairOfDices);
            if (IsValid(aPairOfDices)) {
                if(isTutto(aPairOfDices)) {
                    // if rolled a list of dices that is all valid(accomplish one tutto),
                    // set numOfDices = 6 and continue roll
                    keptDices.addAll(aPairOfDices);
                    numOfDices = 6;
                    if(keptDices.size() == 12) {
                        System.out.println("Congratulations! You accomplish a Tutto!");
                        notTutto = false;
                        continueTurn = false;
                        break;
                    }
                }
                while (notTutto){
                    // Ask the player which dices he/she would like to keep
                    /* break out of the notTutto while loop,but not change the notTutto value*/
                    ArrayList<Integer> dicesToKeep = Dices.GetKeepDices();
                    while (!IsValidKeep(dicesToKeep, aPairOfDices)){
                        System.out.println("Invalid Input! Please re-enter:");
                        dicesToKeep = Dices.GetKeepDices();
                    }
                    keptDices.addAll(dicesToKeep);
                    numOfDices -= dicesToKeep.size();
                    break;// end the turn
                }
            } else { // null case
                System.out.println("You rolled a null! Your turn is over.");
                keptDices = new ArrayList<>();
                continueTurn = false;
            }
        }
    }
}
