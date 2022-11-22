import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public Game() {
    }

    ArrayList<Card> CardSet = new ArrayList<>();
    private Card DrawACard() {
        Card card = CardSet.get(-1);
        CardSet.remove(-1);
        return card;
    }

    Scanner scanner = new Scanner(System.in);
    Input input = new Input();
    int numberOfPlayers = input.getNumberofplayers();
    ArrayList<Player> ListOfPlayers = new ArrayList<>();

//    private ArrayList<Integer> RollDices(int numOfDices) {
//        ArrayList<Integer> ListOfDices = new ArrayList<>();
//        for(int i = 0; i < numOfDices; i ++){
//            Random r = new Random();
//            int n = r.nextInt(7);
//            ListOfDices.add(n);
//        }
//        return ListOfDices;
//    }
//
//    public void DisplayDices(ArrayList<Integer> ListOfDices) {
//        for(int i = 0; i < ListOfDices.size(); i++) {
//            System.out.print(ListOfDices.get(i) + ' ');
//        }
//    }
//
//    private boolean IsValid(ArrayList<Integer> ListOfDices) {
//        int occurrences;
//        for(int i = 0; i < ListOfDices.size(); i++) {
//            occurrences = Collections.frequency(ListOfDices, ListOfDices.get(i));
//            if(ListOfDices.get(i) == 1 || ListOfDices.get(i) == 5 || occurrences >= 3) {
//                return true;
//            }
//        }
//        return false;
//
//    }
//    private boolean IsValidKeep(ArrayList<Integer> KeepDices) {
//        if(KeepDices.size() == 1 && (KeepDices.get(0) == 1 || KeepDices.get(0) == 5)) {
//            return true;
//        }
//        else if(KeepDices.size() == 3 && ((KeepDices.get(0) == KeepDices.get(1)) && (KeepDices.get(1) == KeepDices.get(2)))) {
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
//
//    private int CalScores(ArrayList<Integer> Dices) {
//        int Scores = 0;
//        int occurrences = 0;
//        ArrayList<Integer> CurrentDices = Dices;
//
//        for(int i = 0; i < Dices.size(); i++) {
//            occurrences = Collections.frequency(Dices, Dices.get(i));
//            if(occurrences == 3) {
//                if(Dices.get(i) == 2||Dices.get(i) == 3||Dices.get(i) == 4||Dices.get(i) == 5||Dices.get(i) == 6) {
//                    Scores = Scores + Dices.get(i) * 100;
//                    CurrentDices.remove(Integer.valueOf(Dices.get(i)));
//                    CurrentDices.remove(Integer.valueOf(Dices.get(i)));
//                    CurrentDices.remove(Integer.valueOf(Dices.get(i)));
//                }
//                else if(Dices.get(i) == 1) {
//                    Scores = Scores + 1000;
//                    CurrentDices.remove(Integer.valueOf(Dices.get(i)));
//                }
//            }
//        }
//        for (int i = 0; i < CurrentDices.size(); i++) {
//            if(CurrentDices.get(i) == 1) {
//                Scores = Scores + 100;
//            }
//            else if(CurrentDices.get(i) == 5) {
//                Scores = Scores + 50;
//            }
//        }
//
//        return Scores;
//    }

    Logic logic = new Logic();
    public void GameOn(){

        for(int i = 0; i < numberOfPlayers; i++){
            Player player = new Player(input.getPlayers().get(i), 0);
            ListOfPlayers.add(player);
        }

        boolean Win = false;
        while(!Win) {
            for(Player player: ListOfPlayers) {
                Card card = DrawACard();
                switch (card.CardType){
                    case STOP:
                        break;
                    case BONUS:
                        player.setScore(logic.Halfwayendturn(player) + card.AddScore);
                    case MULTIPLY_TWO:
                        player.setScore(logic.Halfwayendturn(player));
                }
            }
        }
    }

//    private int BonusLogic(Player player) {
//        int DicesScore = 0;
//        boolean Turn = true;
//        while(Turn) {
//            System.out.println("Would you like to Roll or Display current scores?");
//            System.out.println("Enter 'D' if you want to Display current scores; Enter 'R' if you want to Roll.");
//            String option = scanner.next();
//
//            if(option == "D") {
//                System.out.print(player.getScore());
//            }
//            else if(option == "R") {
//                ArrayList<Integer> ValidDices = new ArrayList<>();
//                int CurrentDices = 6;
//                ArrayList<Integer> Dices = RollDices(CurrentDices);
//                DisplayDices(Dices);
//                if(IsValid(Dices)) {
//                    System.out.println("Would you like to End or Continue?");
//                    System.out.println("Enter 'E' if you want to End.");
//                    String option2 = scanner.next();
//                    boolean Flag = true;
//                    if(option2 == "E") {
//                        Turn = false;
//                        Flag = false;
//                        DicesScore = CalScores(Dices);
//                    }
//
//                    while(Flag){ //Keep valid dices
//                        System.out.println("Please select the Dices you want to keep");
//                        System.out.println("And separate each number with ','"); //e.g 2,2,2
//                        String keep = scanner.nextLine();
//                        String[] KeepDices = keep.split(",");
//                        ArrayList<Integer> IntKeepDices = new ArrayList<>();
//                        for(String s: KeepDices) IntKeepDices.add(Integer.valueOf(s));
//
//                        if(IsValidKeep(IntKeepDices)){
//                            ValidDices.addAll(IntKeepDices);
//                            if(ValidDices.size() == 6) {
//                                System.out.println("You accomplished a Tutto!");
//                                DicesScore = CalScores(Dices);
//                                System.out.println("Would you like to End or Continue?");
//                                System.out.println("Enter 'E' if you want to End.");
//                                String option3 = scanner.next();
//                                if(option3 == "E") {
//                                    Turn = false;
//                                    //Flag = false;
//                                }
//                            }
//                            CurrentDices = CurrentDices - IntKeepDices.size();
//                            Flag = false;
//                        }
//                        else{
//                            System.out.println("Invalid Selection! Please input again");
//                        }
//                    }
//
//                }
//                else {
//                    Turn = false;
//                }
//            }
//            else {
//                System.out.println("Invalid Input! Please input again");
//            }
//        }
//        return DicesScore;
//    }


















    private void GenerateCardSet(){

        for (int i = 0; i < 5; i++) {
            Card Bonus = new Card(CardType.BONUS, 200);
            CardSet.add(Bonus);
        }
        for (int i = 0; i < 5; i++) {
            Card Bonus = new Card(CardType.BONUS, 300);
            CardSet.add(Bonus);
        }
        for (int i = 0; i < 5; i++) {
            Card Bonus = new Card(CardType.BONUS, 400);
            CardSet.add(Bonus);
        }
        for (int i = 0; i < 5; i++) {
            Card Bonus = new Card(CardType.BONUS, 500);
            CardSet.add(Bonus);
        }
        for (int i = 0; i < 5; i++) {
            Card Bonus = new Card(CardType.BONUS, 600);
            CardSet.add(Bonus);
        }
        for (int i = 0; i < 5; i++) {
            Card MultiplyTwo = new Card(CardType.MULTIPLY_TWO, 0);
            CardSet.add(MultiplyTwo);
        }
        for (int i = 0; i < 10; i++) {
            Card Stop = new Card(CardType.STOP, 0);
            CardSet.add(Stop);
        }
        for (int i = 0; i < 5; i++) {
            Card FireWorks = new Card(CardType.FIREWORKS, 0);
            CardSet.add(FireWorks);
        }
        for (int i = 0; i < 5; i++) {
            Card Plus_Minus = new Card(CardType.PLUS_MINUS, 0);
            CardSet.add(Plus_Minus);
        }
        Card CloverLeaf = new Card(CardType.CLOVERLEAF, 0);
        CardSet.add(CloverLeaf);

        for (int i = 0; i < 5; i++) {
            Card Straight = new Card(CardType.STRAIGHT, 0);
            CardSet.add(Straight);
        }
        Collections.shuffle(CardSet);
    }


}
