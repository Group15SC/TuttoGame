package main.Logics;

import main.GameController.UI;

import java.util.ArrayList;

public class BonusLogic extends Logic {

    private ArrayList<Integer> aPairOfDices;
    private ArrayList<Integer> keptDices;
    private boolean notTutto = true;
    private boolean continueTurn = true;

    public void setaPairOfDices(ArrayList<Integer> aPairOfDices) {
        this.aPairOfDices = aPairOfDices;
    }

    public void setKeptDices(ArrayList<Integer> keptDices) {
        this.keptDices = keptDices;
    }

    public void setNotTutto(boolean notTutto) {
        this.notTutto = notTutto;
    }

    public void setContinueTurn(boolean continueTurn) {
        this.continueTurn = continueTurn;
    }

    public boolean isTutto() {
        return !notTutto;
    }

    public ArrayList<Integer> getKeptDices() {
        return keptDices;
    }

    public BonusLogic(RollDice dice) {
        super(dice);
    }

        /* Try to accomplish a TUTTO
            The player may stop after each roll */

    @Override
    public void getValidDices() {
        keptDices = new ArrayList<>(); // empty the kept dices
        int numOfDices = 6;
        while (continueTurn){
            aPairOfDices = new ArrayList<>(); //empty the dice set
            rollAPair(numOfDices, aPairOfDices);
            Dices.displayDices(aPairOfDices);
            if(IsValid(aPairOfDices)){
                if(isTutto(aPairOfDices)) {
                    keptDices.addAll(aPairOfDices);
                    System.out.println("Congratulations! You accomplish a Tutto!");
                    notTutto = false;
                    continueTurn = false;
                    break;
                }
                String HalfwayOpt = UI.halfwayOption(); // player decides to end the turn halfway
                numOfDices = handleNotTutto(numOfDices, HalfwayOpt, notTutto); // update
            } else{
                System.out.println("You rolled a null! Your turn is over.");
                keptDices = new ArrayList<>();
                continueTurn = false;
            }
        }
    }


    public int handleNotTutto(int numOfDices, String HalfwayOpt, boolean notTutto) { // handle re-rolling case, update number of dices
        while (notTutto){
            // Ask the player which dices he/she would like to keep
            /* break out of the notTutto while loop,but not change the notTutto value*/
            if (HalfwayOpt.equals("E")) {
                keptDices.addAll(ValidInThisRoll(aPairOfDices));
                continueTurn = false;
            } else {
                ArrayList<Integer> dicesToKeep = Dices.getKeepDices();
                while (!IsValidKeep(dicesToKeep, aPairOfDices)){
                    System.out.println("Invalid Input! Please re-enter:");
                    dicesToKeep = Dices.getKeepDices();
                }
                keptDices.addAll(dicesToKeep);
                numOfDices -= dicesToKeep.size();
            }
            break;// end the turn
        }
        return numOfDices;
    }
}