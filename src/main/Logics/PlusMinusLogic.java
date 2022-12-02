package main.Logics;

import main.GameController.GameInitialization;

import java.util.ArrayList;

public class PlusMinusLogic extends Logic {
    public PlusMinusLogic(RollDices dice) {
        super(dice);
    }

    /* Try to accomplish a TUTTO and may not stop in halfway
        if the player roll a null, his/her turn is over
        the functionality of this card ends when accomplish a TUTTO */

    @Override
    public ArrayList<Integer> GetValidDices() {
        // logic of plus/minus card
        ArrayList<Integer> ValidDices = new ArrayList<>();
            int CurrentDices = 6;
            boolean isValid = true;
            while (isValid) {
                // store and display result of dice rolling
                Dices dices = new Dices();
                ArrayList<Integer> RolledDices = dices.RollDices(CurrentDices);
                GameInitialization.DisplayDices(RolledDices);

                ArrayList<Integer> DicesToKeep;

                if (Logic.IsValid(RolledDices)) {
                    // keep valid dices flag
                    boolean flag = true;
                    while (flag) {
                        // Ask the player which dices he/she would like to keep
                        DicesToKeep = Dices.GetKeepDices();
                        if (Logic.IsValidKeep(DicesToKeep)) {
                            // if all the player's input dices are valid, append them to valid dice list
                            ValidDices.addAll(DicesToKeep);
                            CurrentDices -= DicesToKeep.size();
                            if (ValidDices.size() == 6) {
                                /*player accomplish a Tutto, the functionality of this card ends */
                                break;
                            }
                            break;
                            /* the break is used to get out of the flag while loop,
                            go back to the isValid while loop,
                            use the updated current dices to roll (i.e. roll the remaining dices) */
                        }
                    }
                }
                else { // null case
                    System.out.println("You rolled a null! Your turn is over.");
                    ValidDices = new ArrayList<>();
                    isValid = false;
                }
            }
        return ValidDices;
    }
}
