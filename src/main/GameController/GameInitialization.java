package main.GameController;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class GameInitialization {
    int NumberOfPlayers;
    int WinningPoints;
    ArrayList<String> Players;


    private Scanner scanner = new Scanner(System.in);

    private int AskForNumberOfPlayers() {
        System.out.println("Please enter the number of players (2-4): ");
        int num = scanner.nextInt();
        while (num < 2 || num > 4) {
            System.out.println("Please note the number of players must be between 2 and 4!");
            System.out.println("Please re-enter the number of players: ");
            num = scanner.nextInt();
        }
        return num;
    }

    private int AskForWinningPoints() {
        System.out.println("Please define the winning points:");
        return scanner.nextInt();
    }

    private String AskForName() {
        return scanner.next();
    }

    public static void DisplayDices(ArrayList<Integer> ListOfDices) {
        System.out.println("The result of this roll is:");
        for(int dice: ListOfDices) {
            System.out.print(dice);
            System.out.print(" ");
        }
        System.out.println();
    }
    public GameInitialization(){
        this.NumberOfPlayers = AskForNumberOfPlayers();
        ArrayList<String> Players = new ArrayList<>();
        for(int i=0; i < NumberOfPlayers; i++) {
            System.out.println("Please enter the name of Player" + (i+1) +":");
            String player = AskForName();
            Players.add(player);
        } Collections.sort(Players); //sort the list of players alphabetically
        this.Players = Players;
        this.WinningPoints = AskForWinningPoints();
    }

    public int GetNumberOfPlayers() {
        return NumberOfPlayers;
    }

    public int GetWinningPoints() {
        return WinningPoints;
    }

    public ArrayList<String> getPlayers() {
        return Players;
    }
}
