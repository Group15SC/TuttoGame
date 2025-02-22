package main.Logics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Dices implements RollDice {
    @Override
    public int rollDice() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }

    public static void displayDices(ArrayList<Integer> ListOfDices) {
        System.out.println("The result of this roll is:");
        for(int dice: ListOfDices) {
            System.out.print(dice);
            System.out.print(" ");
        }
        System.out.println();
    }


    public static int calScoresOfDices(ArrayList<Integer> Dices) {
        int Scores = 0;
        int occurrences = 0;
//        ArrayList<Integer> currentDices = Dices;

        ArrayList<Integer> cloneDices = new ArrayList<>();

        for(int diceVal:Dices){
            cloneDices.add(diceVal); // in case the remove operation will change the original pair
        }

        for(int i=0; i<cloneDices.size(); i++) {
            int dice = cloneDices.get(i);
            occurrences = Collections.frequency(Dices, dice);
            if(occurrences == 3) {
                if(dice != 1) {
                    // Triplet 2,3,4,5,6 gets 200,300,400,500,600 respectively
                    Scores = Scores + Dices.get(i) * 100;
                }
                else if(dice == 1) {
                    // Triplet 1 gets 1000
                    Scores = Scores + 1000;
                }
                cloneDices.remove(Integer.valueOf(dice));
                cloneDices.remove(Integer.valueOf(dice));
                cloneDices.remove(Integer.valueOf(dice));
            }
        }
        for (int i=0; i<cloneDices.size(); i++) {
            if(cloneDices.get(i) == 1) {
                Scores = Scores + 100;
            }
            else if(cloneDices.get(i) == 5) {
                Scores = Scores + 50;
            }
        }
        return Scores;
    }

    public static ArrayList<Integer> getKeepDices() {
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
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input! Please re-enter:");
            }
        }
        return IntKeepDices;
    }


}
