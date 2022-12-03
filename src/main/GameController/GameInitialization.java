package main.GameController;

import main.Logics.RollDice;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class GameInitialization {
    int NumberOfPlayers;
    int WinningPoints;
    ArrayList<String> Players;

    private Scanner scanner = new Scanner(System.in);

    private int AskForNumberOfPlayers() {

//        System.out.println("Please enter the number of players (2-4): ");
//        int num = scanner.nextInt();
//        while (num < 2 || num > 4) {
//            System.out.println("Please note the number of players must be between 2 and 4!");
//            System.out.println("Please re-enter the number of players: ");
//            num = scanner.nextInt();
//        }
        int num = 0;
        String strInput;
        boolean valid = false;
        while(valid == false) {
            System.out.println("Please enter the number of players (2-4): ");
            strInput = scanner.nextLine();
            try {
                num = Integer.parseInt(strInput);
                if((num >= 2) && (num <= 4)) {
                    valid = true;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Please note the number of players must be between 2 and 4!");
                System.out.println("Please re-enter the number of players: ");
            }
        }
        return num;
    }

    private ArrayList<String> storePlayers () {
        ArrayList<String> Players = new ArrayList<>();
        for(int i = 0; i < this.NumberOfPlayers; i++) {
            System.out.println("Please enter the name of Player" + (i+1) +":");
            String player = scanner.next();
            Players.add(player);
        }
        Collections.sort(Players); //sort the list of players alphabetically
        return Players;
    }

    private int AskForWinningPoints() {
        System.out.println("Please define the winning points:");
        int winningPoints = scanner.nextInt();
        return winningPoints;
    }

//    private String AskForName() {
//        return scanner.next();
//    }
    public void setUp() {
        this.NumberOfPlayers = AskForNumberOfPlayers();
        this.Players = storePlayers();
        this.WinningPoints = AskForWinningPoints();
    }
    public GameInitialization() {
        setUp();
//        this.numOfPlayers = AskForNumberOfPlayers();
//        this.Players = storePlayers();
//        this.WinningPoints = AskForWinningPoints();
    }

    public int GetNumberOfPlayers() {
        return this.NumberOfPlayers;
    }

    public int GetWinningPoints() {
        return this.WinningPoints;
    }

    public ArrayList<String> getPlayers() {
        return this.Players;
    }
}
