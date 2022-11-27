package TuttoGame.Logics;

import TuttoGame.GameController.Player;
import TuttoGame.Logic;

import java.util.ArrayList;

public class CloverleafLogic extends Logic{

    @Override
    public ArrayList<Integer> GetValidDices(Player player) {
        ArrayList<Integer> ValidDices = new ArrayList<>();
        int CurrentDices = 6;
        // get the option
        String option = Logic.TurnSartingOption();
        // choosing display: display current score

        while(option.equals("D")){
            System.out.println(player.getScore());
            option = Logic.TurnSartingOption();
        } if (option.equals("R")) {
            boolean isValid = true;
            while (isValid) {
                // store and display result of dice rolling
                ArrayList<Integer> RolledDices = Dices.RollDices(CurrentDices);
                Dices.DisplayDices(RolledDices);
                ArrayList<Integer> DicesToKeep;
                if (Logic.IsValid(RolledDices)) {
                    // Ask the player which dices she/he would like to keep
                    DicesToKeep = Dices.GetKeepDices();
                    if (Logic.IsValidKeep(DicesToKeep)) {
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
        }
        else {
            System.out.println("Invalid Input! Please input again");
        }
        return ValidDices;
    }

}
