package TuttoGame.Logics;

import TuttoGame.GameController.Player;
import TuttoGame.Logic;

import java.util.ArrayList;

public class FireworksLogic extends Logic {

    @Override
    public ArrayList<Integer> GetValidDices() {
        ArrayList<Integer> ValidDices = new ArrayList<>();
        /* FIREWORKS:
            keep throwing the dice until roll a null
            after each roll, keep all valid dices and triplets*/

//        String option = Logic.TurnSartingOption();
//        // choosing display: display current score
//        while(option.equals("D")){
//            System.out.println(player.getScore());
//            option = Logic.TurnSartingOption();
//        } if (option.equals("R")) {
            int CurrentDices = 6;
            boolean isValid = true;

            while (isValid) {
                // store and display the result of dice rolling
                ArrayList<Integer> RolledDices = Dices.RollDices(CurrentDices);
                Dices.DisplayDices(RolledDices);
                if (Logic.IsValid(RolledDices)) {
                    // keep all valid single dice and triplets
                    ArrayList<Integer> DicesToKeep = ValidInThisRoll(RolledDices);
                    ValidDices.addAll(DicesToKeep);
                    // roll the other invalid dices
                    CurrentDices -= DicesToKeep.size();
                    // check if all the 6 dices have been kept
                    if (ValidDices.size() == 6) {
                        /*player accomplish a Tutto, restart rolling 6 dices*/
                        CurrentDices = 6;
                    }
                }
                // if get a null
                else {
                    System.out.println("You rolled a null! Your turn is over.");
                    isValid = false;
                }
            }
        //}
        return ValidDices;
    }
}
