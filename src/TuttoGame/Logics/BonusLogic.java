package TuttoGame.Logics;

import TuttoGame.GameController.Player;
import TuttoGame.Logic;

import java.util.ArrayList;

public class BonusLogic extends Logic {

    //boolean isTutto = false;

    @Override
    public ArrayList<Integer> GetValidDices(Player player) {
        ArrayList<Integer> ValidDices = new ArrayList<>();
        boolean ThisTurn = true;

        while(ThisTurn) {
            // get the option
            String option = Logic.TurnSartingOption();
            // choosing display: display current score
            if (option == "D") {
                System.out.print(player.getScore());
            }
            // choosing roll: roll the dice
            else if (option == "R") {
                int CurrentDices = 6;
                if(CurrentDices > 0) {
                    // result of dice rolling
                    ArrayList<Integer> RolledDices = Dices.RollDices(CurrentDices);
                    Dices.DisplayDices(RolledDices);

                    if (Logic.IsValid(RolledDices)) {
                        // keep valid dices flag
                        boolean Flag = true;
                        // Ask the player if he/she wanna continue rolling or end this turn here
                        String halfwayopt = Logic.HalfwayOption();
                        // player decides to end the turn halfway
                        if (halfwayopt == "E") {
                            // return the valid dices obtained after this roll
                            ValidDices.addAll(ValidInThisRoll(RolledDices));
                            Flag = false;
                            ThisTurn = false; // end this turn
                        }
                        ArrayList<Integer> DicesToKeep = new ArrayList<>();
                        while (Flag) {
                            // Ask the player which dices he/she would like to keep
                            DicesToKeep = Dices.GetKeepDices();
                            if (Logic.IsValidKeep(DicesToKeep)) {
                                // if all the player's input dices are valid, append them to valid dice list
                                ValidDices.addAll(DicesToKeep);
                                CurrentDices -= DicesToKeep.size();
                                if (ValidDices.size() == 6) {
                                    /*player accomplish a Tutto, the functionality of this card ends */
                                    ThisTurn = false;
                                }
                            }
                        }
                    } else {
                        ThisTurn = false; // rolled a null, get no points in this turn
                    }
                }
            }
            else if (option == "E") {
                System.out.println("You may not end now!");
            }
            else {
                System.out.println("Invalid Input! Please input again");
            }
        }
        return ValidDices;
    }
}
