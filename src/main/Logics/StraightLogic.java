package main.Logics;

import main.GameController.GameInitialization;

import java.util.ArrayList;

public class StraightLogic extends Logic {

    public StraightLogic(RollDices dice) {
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

    @Override
    public ArrayList<Integer> GetValidDices() {
        /* logic of Straight card, return all the valid dices
            note that the logic of valid dice is different from other cards */

        ArrayList<Integer> ValidDices = new ArrayList<>();

        int NumOfCurrentDices = 6;
            boolean isValid = true;

            while (isValid) {
                // store and display result of dice rolling
                Dices dices = new Dices();
                ArrayList<Integer> RolledDices = dices.RollDices(NumOfCurrentDices);
                Dices.DisplayDices(RolledDices);
                ArrayList<Integer> DicesToKeep;

                if (IsValidForStraight(RolledDices, ValidDices)) {
                    // If there exist dice valid to keep, ask the player which dices he/she would like to keep
                    DicesToKeep = Dices.GetKeepDices();
                    // if all the player's input dices are valid, append them to valid dice list
                    NumOfCurrentDices -= DicesToKeep.size();
                    ValidDices.addAll(DicesToKeep);
                    if (ValidDices.size() == 6) {
                        /*player accomplish a Tutto, the functionality of this card ends */
                        return ValidDices;
                    }
                        /* the break is used to get out of the flag while loop,
                                    go back to the isValid while loop,
                                    use the updated current dices to roll (i.e. roll the remaining dices) */
                } else { // null case
                    System.out.println("You rolled a null! Your turn is over.");
                    ValidDices = new ArrayList<>();
                    isValid = false;
                }
            }
        return ValidDices;
    }
}
