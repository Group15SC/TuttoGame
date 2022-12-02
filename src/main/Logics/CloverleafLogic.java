package main.Logics;

import main.GameController.GameInitialization;

import java.util.ArrayList;

public class CloverleafLogic extends Logic {

    public CloverleafLogic(RollDices dice) {
        super(dice);
    }

    @Override
    public ArrayList<Integer> GetValidDices() {
        ArrayList<Integer> ValidDices = new ArrayList<>();
        int CurrentDices = 6;
            boolean isValid = true;
            while (isValid) {
                // store and display result of dice rolling
                Dices dices = new Dices();
                ArrayList<Integer> RolledDices = dices.RollDices(CurrentDices);
                Dices.DisplayDices(RolledDices);
                ArrayList<Integer> DicesToKeep;
                if (IsValid(RolledDices)) {
                    // Ask the player which dices she/he would like to keep
                    DicesToKeep = Dices.GetKeepDices();
                    if (IsValidKeep(DicesToKeep)) {
                        // if all the player's input dices are valid, append them to valid dice list
                        ValidDices.addAll(DicesToKeep);
                        CurrentDices -= DicesToKeep.size();
                        if (ValidDices.size() == 6) {
                            CurrentDices = 6;
                        } else if (ValidDices.size() == 12) {
                            /*player accomplish a Tutto, the functionality of this card ends */
                            return ValidDices;
                        }
//                        break;
                            /* the break is used to get out of the flag while loop,
                            go back to the isValid while loop,
                            use the updated current dices to roll (i.e. roll the remaining dices) */
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
