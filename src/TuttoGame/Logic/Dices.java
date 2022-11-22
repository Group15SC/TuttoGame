package TuttoGame.Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Dices {

    public static ArrayList<Integer> RollDices(int numOfDices) {
        ArrayList<Integer> ListOfDices = new ArrayList<>();
        for(int i = 0; i < numOfDices; i ++){
            Random r = new Random();
            int n = r.nextInt(7);
            ListOfDices.add(n);
        }
        return ListOfDices;
    }

    public static void DisplayDices(ArrayList<Integer> ListOfDices) {
        for(int i = 0; i < ListOfDices.size(); i++) {
            System.out.print(ListOfDices.get(i) + ' ');
        }
    }

    public static int CalDiceScores(ArrayList<Integer> Dices) {
        int Scores = 0;
        int occurrences = 0;
        ArrayList<Integer> CurrentDices = Dices;

        for(int i = 0; i < Dices.size(); i++) {
            occurrences = Collections.frequency(Dices, Dices.get(i));
            if(occurrences == 3) {
                if(Dices.get(i) == 2||Dices.get(i) == 3||Dices.get(i) == 4||Dices.get(i) == 5||Dices.get(i) == 6) {
                    Scores = Scores + Dices.get(i) * 100;
                    CurrentDices.remove(Integer.valueOf(Dices.get(i)));
                    CurrentDices.remove(Integer.valueOf(Dices.get(i)));
                    CurrentDices.remove(Integer.valueOf(Dices.get(i)));
                }
                else if(Dices.get(i) == 1) {
                    Scores = Scores + 1000;
                    CurrentDices.remove(Integer.valueOf(Dices.get(i)));
                }
            }
        }
        for (int i = 0; i < CurrentDices.size(); i++) {
            if(CurrentDices.get(i) == 1) {
                Scores = Scores + 100;
            }
            else if(CurrentDices.get(i) == 5) {
                Scores = Scores + 50;
            }
        }

        return Scores;
    }

    public static ArrayList<Integer> GetKeepDices() {
        ArrayList<Integer> IntKeepDices = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select the Dices you want to keep");
        System.out.println("And separate each number with ','"); //e.g 2,2,2
        String keep = scanner.nextLine();
        String[] KeepDices = keep.split(",");
        for(String s: KeepDices) IntKeepDices.add(Integer.valueOf(s));
        return IntKeepDices;
    }

}
