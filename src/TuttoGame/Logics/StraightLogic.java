package TuttoGame.Logics;

import TuttoGame.GameController.Player;
import TuttoGame.Logic;

import java.util.ArrayList;

public class StraightLogic extends Logic{

    @Override
    public ArrayList<Integer> GetValidDices(Player player) {

        // logic of Straight card, return all the valid dices
        // note that the logic of valid dice is different from other cards

        ArrayList<Integer> ValidDices = new ArrayList<>();

        String option = Logic.TurnSartingOption();
        // choosing display: display current score
        if (option.equals("D")) {
            System.out.print(player.getScore());
        }
        else if (option.equals("R")) {
            boolean isValid = true;
            int NumOfCurrentDices = 6;
            while (isValid) {
                // store and display result of dice rolling
                ArrayList<Integer> RolledDices = Dices.RollDices(NumOfCurrentDices);
                Dices.DisplayDices(RolledDices);
                ArrayList<Integer> DicesToKeep;

                if (Logic.IsValidForStraight(RolledDices, ValidDices)) {
                    // If there exist dice valid to keep, ask the player which dices he/she would like to keep
                    DicesToKeep = Dices.GetKeepDices();
                    if (Logic.IsValidKeepForStraight(DicesToKeep, ValidDices)) {
                        // if all the player's input dices are valid, append them to valid dice list
                        NumOfCurrentDices -= DicesToKeep.size();
                        ValidDices.addAll(DicesToKeep);
                        if (ValidDices.size() == 6) {
                            /*player accomplish a Tutto, the functionality of this card ends */
                            return ValidDices;
                        }
                        break;
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
