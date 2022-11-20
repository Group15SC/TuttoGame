import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Input {
    int numberofplayers;
    int winningpoints;
    ArrayList<String> Players;


    private Scanner scanner = new Scanner(System.in);
    Card card = DrawACard();
    private int Askfornumberofplayers() {
        System.out.println("Please enter the number of players (2-4): ");
        int num = scanner.nextInt();
        while (num < 2 || num > 4) {
            System.out.println("Please note the number of players must be between 2 and 4!");
            System.out.println("Please re-enter the number of players: ");
            num = scanner.nextInt();
        }
        return num;
    }

    private int Askforwinningpoints() {
        System.out.println("Please define the winning points:");
        int points = scanner.nextInt(); // any limits?
        return points;
    }

    private String Askforname() {
        String name = scanner.next();
        return name;
    }

    public Input(){
        this.numberofplayers = Askfornumberofplayers();
        ArrayList<String> Players = new ArrayList<>();
        for(int i=0; i < numberofplayers; i++) {
            System.out.println("Please enter the name of Player" + (i+1) +":");
            String player = Askforname();
            Players.add(player);
        } Collections.sort(Players); //sort the list of players alphabetically
        this.Players = Players;
        this.winningpoints = Askforwinningpoints();
    }

    public int getNumberofplayers() {
        return numberofplayers;
    }

    public int getWinningpoints() {
        return winningpoints;
    }

    public ArrayList<String> getPlayers() {
        return Players;
    }
}
