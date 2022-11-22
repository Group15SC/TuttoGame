import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Logic {

    protected static boolean IsValid(ArrayList<Integer> ListOfDices) {
        int occurrences;
        for (int i = 0; i < ListOfDices.size(); i++) {
            occurrences = Collections.frequency(ListOfDices, ListOfDices.get(i));
            if (ListOfDices.get(i) == 1 || ListOfDices.get(i) == 5 || occurrences >= 3) {
                return true;
            }
        }
        return false;
    }

    protected static boolean IsValidKeep(ArrayList<Integer> KeepDices) {
        if(KeepDices.size() == 1 && (KeepDices.get(0) == 1 || KeepDices.get(0) == 5)) {
            return true;
        }
        else if(KeepDices.size() == 3 && ((KeepDices.get(0) == KeepDices.get(1)) && (KeepDices.get(1) == KeepDices.get(2)))) {
            return true;
        }
        else {
            return false;
        }
    }

    protected static String TurnSartingOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to Roll or Display current scores?");
        System.out.println("Enter 'D' if you want to Display current scores; Enter 'R' if you want to Roll.");
        String option = scanner.next();
        return option;
    }

    protected static String HalfwayOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to End or Continue?");
        System.out.println("Enter 'E' if you want to End.");
        String halfwayopt = scanner.next();
        return halfwayopt;
    }

    protected static String TuttoOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You accomplished a Tutto!");
        System.out.println("Would you like to End or Continue?");
        System.out.println("Enter 'E' if you want to End.");
        String tuttooption = scanner.next();
        return tuttooption;
    }

    public static int Halfwayendturn(Player player) {
        boolean Turn = true;
        int DicesScore = 0;
        while(Turn) {
            String option = TurnSartingOption(); // get the option
            if (option == "D") {
                System.out.print(player.getScore());
            } else if (option == "R") {
                ArrayList<Integer> ValidDices = new ArrayList<>(); // keep the valid dices
                int CurrentDices = 6;
                ArrayList<Integer> dices = Dices.RollDices(CurrentDices);
                Dices.DisplayDices(dices);
                if (IsValid(dices)) {
                    boolean Flag = true;
                    String halfwayopt = HalfwayOption();
                    if (halfwayopt == "E") { // player decides to end the turn halfway
                        Flag = false;
                        Turn = false; // end this turn
                        DicesScore = Dices.CalDiceScores(dices); // only get the score of rolling dices
                    }
                    ArrayList<Integer> dicestokeep = null;
                    while (Flag) {
                        dicestokeep = Dices.GetKeepDices();
                        if (IsValidKeep(dicestokeep)) {
                            ValidDices.addAll(dicestokeep); //append player's choice to valid dice list
                            if (ValidDices.size() == 6) {
                                /*player accomplish a Tutto,
                                the functionality of this card ends */
                                Turn = false;
                                DicesScore = Dices.CalDiceScores(ValidDices);
//                                String tuttoopt = TuttoOption();
//                                if (tuttoopt == "E") {
                            }
                        }
                    }
                    CurrentDices -= dicestokeep.size();
                    Flag = false;
                } else {
                    Turn = false; // rolled a null, get no points in this turn
                }
            }
            else if (option == "E") {
                System.out.println("You may not end now!");
            }
            else {
                System.out.println("Invalid Input! Please input again");
            }
        }
        return DicesScore;
    }

    //public abstract int GetScore(Player player);

}
