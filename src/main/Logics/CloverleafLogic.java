package main.Logics;

import java.util.ArrayList;

public class CloverleafLogic extends Logic {

    private ArrayList<Integer> aPairOfDices;
    private ArrayList<Integer> keptDices;
    private boolean notTutto = true;
    private boolean continueTurn = true;

    public ArrayList<Integer> getKeptDices() {
        return keptDices;
    }

    public boolean isTutto() {
        return !notTutto;
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
            notTutto = true;
            rollAPair(numOfDices, aPairOfDices);
            Dices.displayDices(aPairOfDices);
            if (isValid(aPairOfDices)) {
                if(isTutto(aPairOfDices)) {
                    // if rolled a list of dices that is all valid(accomplish one tutto),
                    // set numOfDices = 6 and continue roll
                    System.out.println("Congratulations! You accomplish a Tutto!");
                    keptDices.addAll(aPairOfDices);
                    notTutto = false;
                    numOfDices = 6;
                    if(keptDices.size() == 12) {
                        notTutto = false;
                        continueTurn = false;
                        break;
                    }
                }
                while (notTutto){
                    ArrayList<Integer> dicesToKeep = new ArrayList<>();
                    // Ask the player which dices he/she would like to keep
                    /* break out of the notTutto while loop,but not change the notTutto value*/
                    dicesToKeep = Dices.getKeepDices();
                    while (!isValidKeep(dicesToKeep, aPairOfDices)){
                        System.out.println("Invalid Input! Please re-enter:");
                        dicesToKeep = Dices.getKeepDices();
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
