package TuttoGame.Logic;

import java.util.ArrayList;

public class BonusLogic extends Logic {

    //boolean isTutto = false;

    @Override
    public ArrayList<Integer> GetValidDices(Player player) {
        boolean ThisTurn = true;
        int DicesScore = 0;
        ArrayList<Integer> ValidDices = new ArrayList<>();
        while(ThisTurn) {
            String option = Logic.TurnSartingOption(); // get the option
            if (option == "D") {
                System.out.print(player.getScore());
            } else if (option == "R") {
                // keep the valid dices
                int CurrentDices = 6;

                if(CurrentDices > 0) {
                    // result of dice rolling
                    ArrayList<Integer> RolledDices = Dices.RollDices(CurrentDices);
                    Dices.DisplayDices(RolledDices);
                    if (Logic.IsValid(RolledDices)) {
                        // keep valid dices flag
                        boolean Flag = true;
                        String halfwayopt = Logic.HalfwayOption();
                        // player decides to end the turn halfway
                        if (halfwayopt == "E") {
                            Flag = false;
                            ThisTurn = false; // end this turn
                            DicesScore = Dices.CalDiceScores(RolledDices); // only get the score of rolling dices
                        }
                        ArrayList<Integer> DicesToKeep = new ArrayList<>();
                        while (Flag) {
                            DicesToKeep = Dices.GetKeepDices();
                            if (Logic.IsValidKeep(DicesToKeep)) {
                                ValidDices.addAll(DicesToKeep); //append player's choice to valid dice list
                                CurrentDices -= DicesToKeep.size();
                                if (ValidDices.size() == 6) {
                                    //isTutto = true;
                                    /*player accomplish a Tutto,
                                    the functionality of this card ends */
                                    ThisTurn = false;
                                    DicesScore = Dices.CalDiceScores(ValidDices);
                                    //String tuttoopt = TuttoOption();
                                    //if (tuttoopt == "E") {
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
