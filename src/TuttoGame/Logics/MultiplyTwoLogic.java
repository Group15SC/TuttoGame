package TuttoGame.Logics;

import TuttoGame.GameController.Player;
import TuttoGame.Logic;

import java.util.ArrayList;

public class MultiplyTwoLogic extends Logic {

    @Override
    public ArrayList<Integer> GetValidDices(Player player) {
        // x2 logic return list of valid dices
        ArrayList<Integer> ValidDices = new ArrayList<>();
        // get the option
    String option = Logic.TurnsartingOption();
    // choosing display: display current score
    while(option.equals("D")){
        System.out.println(player.getScore());
        option = Logic.TurnsartingOption();
    } if (option.equals("R")) {
        int CurrentDices =6;
        boolean isValid = true;
        while (isvalid) {
            //store and display results of dice rolling
            ArrayList<Integer>RolledDices = Dices.RollDices(CurrentDices);
            Dices.DisplayDices(RolledDices);
             
            ArrayList<Integer>DicesToKeep;
            if (Logic.IsValid(RolledDices)) {
                // keep valid dices flag
                boolean Flag = true;
                while (Flag) {
                    // Ask the player if he/she wanna continue rolling or end this turn here
                    String halfwayopt = Logic.HalfwayOption();

                    // player decides to end the turn halfway
                    if (halfwayopt.equals("E")) {
                        // return the valid dices obtained after this roll
                        ValidDices.addAll(ValidInThisRoll(RolledDices));
                        Flag = false;
                        isValid = false; // end this turn
                    } else {
                        // Ask the player which dices he/she would like to keep
                        DicesToKeep = Dices.GetKeepDices();
                        if (Logic.IsValidKeep(DicesToKeep)) {
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
        } else if (option.equals("E")) {
            System.out.println("You may not end now!");
        } else {
            System.out.println("Invalid Input! Please input again");
        }
   
        return ValidDices;
    }
}
