package main.GameController;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class GameInitialization {
    private Scanner scanner = new Scanner(System.in);

    private ArrayList<String> nameOfPlayers;
    private int winningPoints;

    private int numOfPlayers;

    public GameInitialization() {
        setUp();
    }
    public int askForNumberOfPlayers() {

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
        for(int i = 0; i < this.numOfPlayers; i++) {
            System.out.println("Please enter the name of Player" + (i+1) +":");
            String player = scanner.next();
            Players.add(player);
        }
        Collections.sort(Players); //sort the list of players alphabetically
        return Players;
    }

    private int askForWinningPoints() {
        System.out.println("Please define the winning points:");
        int winningPoints = scanner.nextInt();
        return winningPoints;
    }

    public void setUp() {
        this.numOfPlayers = askForNumberOfPlayers();
        this.nameOfPlayers = storePlayers();
        this.winningPoints = askForWinningPoints();
    }

    public int getNumberOfPlayers() {
        return this.numOfPlayers;
    }

    public int getWinningPoints() {
        return this.winningPoints;
    }

    public ArrayList<String> getPlayers() {
        return this.nameOfPlayers;
    }
}
