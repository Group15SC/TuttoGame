package main.Logics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Dices {

    public static ArrayList<Integer> RollDices(int numOfDices) {
        ArrayList<Integer> ListOfDices = new ArrayList<>();

        for(int i = 0; i < numOfDices; i ++){
            Random r = new Random();
            int n = r.nextInt(6) + 1;
            ListOfDices.add(n);
        }
        return ListOfDices;
    }

    public static void DisplayDices(ArrayList<Integer> ListOfDices) {
        System.out.println("The result of this roll is:");
        for(int dice: ListOfDices) {
            System.out.print(dice);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static int CalDiceScores(ArrayList<Integer> Dices) {
        int Scores = 0;
        int occurrences = 0;
        ArrayList<Integer> CurrentDices = Dices;

        for(int i=0; i<Dices.size(); i++) {
            int dice = Dices.get(i);
            occurrences = Collections.frequency(Dices, dice);
            if(occurrences == 3) {
                if(dice != 1) {
                    // Triplet 2,3,4,5,6 gets 200,300,400,500,600 respectively
                    Scores = Scores + CurrentDices.get(i) * 100;
                }
                else if(dice == 1) {
                    // Triplet 1 gets 1000
                    Scores = Scores + 1000;
                }
                CurrentDices.remove(Integer.valueOf(dice));
                CurrentDices.remove(Integer.valueOf(dice));
                CurrentDices.remove(Integer.valueOf(dice));
            }
        }
        for (int i=0; i<CurrentDices.size(); i++) {
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
        while (true) { // handle invalid input
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please select the Dices you want to keep");
                System.out.println("If you choose to keep a triplet, please separate each number with ','"); //e.g 2,2,2
                String keep = scanner.nextLine();
                String[] KeepDices = keep.split(",");
                for (String s : KeepDices) IntKeepDices.add(Integer.valueOf(s));
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input! Please re-enter:");
            }
        }
        return IntKeepDices;
    }
}
