package main.Logics;

import main.GameController.GameInitialization;
import main.GameController.UI;

import java.util.ArrayList;

public class BonusLogic extends Logic {

    public BonusLogic(RollDices dice) {
        super(dice);
    }

        /* Try to accomplish a TUTTO
            The player may stop after each roll */

    @Override
    public void GetValidDices() {
        ArrayList<Integer> ValidDices = new ArrayList<>();
        int CurrentDices = 6;
//        boolean isValid = true;
//        ArrayList<Integer> d = new ArrayList<>();
//        d = dice.RollDices(CurrentDices);
        setDice(dice.RollDices(CurrentDices));
        while (IsValid(dice.RollDices(CurrentDices))) {
            // store and display result of dice rolling
//            Dices dices = new Dices();

            GameInitialization.DisplayDices(RolledDices);

            ArrayList<Integer> DicesToKeep;
            if (IsValid(RolledDices)) {
                // keep valid dices flag
                boolean Flag = true;
                while (Flag) {
                    // Ask the player if he/she want to continue rolling or end this turn here
                    String HalfwayOpt = UI.HalfwayOption();
                    // player decides to end the turn halfway
                    if (HalfwayOpt.equals("E")) {
                        // return the valid dices obtained after this roll
                        ValidDices.addAll(ValidInThisRoll(RolledDices));
                        Flag = false;
                        isValid = false; // end this turn
                    } else {
                        // Ask the player which dices he/she would like to keep
                        DicesToKeep = Dices.GetKeepDices();
                        if (IsValidKeep(DicesToKeep)) {
                            // if all the player's input dices are valid, append them to valid dice list
                            ValidDices.addAll(DicesToKeep);
                            CurrentDices -= DicesToKeep.size();
                            if (ValidDices.size() == 6) {
                                /*player accomplish a Tutto, the functionality of this card ends */
                                return ValidDices;
                            }
                            break;
                                /* the break is used to get out of the flag while loop,
                                go back to the isValid while loop,
                                use the updated current dices to roll (i.e. roll the remaining dices) */
                        }
                    }
                }
            } else { // null case
                System.out.println("You rolled a null! Your turn is over.");
                ValidDices = new ArrayList<>();
                isValid = false;
            }
        }
        return ValidDices;
    }


}
