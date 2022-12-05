package main.GameController;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class GameInitialization {

    private ArrayList<String> nameOfPlayers;
    private int winningPoints;

    Scanner scanner = new Scanner(System.in);

    private int numOfPlayers;

    private GameInitialization() {
        setUp();
    }

    private static final GameInitialization INSTANCE = new GameInitialization();

    public static GameInitialization getInstance(){
        return INSTANCE;
    }

    public int askForNumberOfPlayers() {
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

        int winningPoints = 0;
        System.out.println("Please define the winning points:");
        while(true) {
            if(scanner.hasNextInt()){
                winningPoints = scanner.nextInt();
                break;
            }
            else {
                System.out.println("Invalid input!");
                System.out.println("Please define the winning points:");
                scanner.next();
            }
        }
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
