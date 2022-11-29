package TuttoGame.GameController;

import TuttoGame.Cards.*;

import TuttoGame.Logic;
import TuttoGame.Logics.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    public Game() {
//        GenerateCardSet();
    }

    ArrayList<Card> CardSet = new ArrayList<>();
    private Card DrawACard() {
        Card card = CardSet.get(-1);
        CardSet.remove(-1);
        return card;
    }

//    Scanner scanner = new Scanner(System.in);
    Input input = new Input();
    int numberOfPlayers = input.GetNumberOfPlayers();
    ArrayList<Player> ListOfPlayers = new ArrayList<>();



    private ArrayList<Integer> DicesOfThisCard(Player player, Card card){
        ArrayList<Integer> dices = new ArrayList<>();
        switch (card.GetCardType()){
            case STOP:
                break;
            case BONUS:
                BonusLogic bonuslogic = new BonusLogic();
                dices = bonuslogic.GetValidDices(player);
                break;
            case MULTIPLY_TWO:
                MultiplyTwoLogic multiplytwologic = new MultiplyTwoLogic();
                dices = multiplytwologic.GetValidDices(player);
                break;
            case FIREWORKS:
                FireworksLogic fireworksLogic = new FireworksLogic();
                dices = fireworksLogic.GetValidDices(player);
                break;
            case CLOVERLEAF:
                CloverleafLogic cloverleaflogic = new CloverleafLogic();
                dices = cloverleaflogic.GetValidDices(player);
                break;
            case PLUS_MINUS:
                PlusMinusLogic plusminuslogic = new PlusMinusLogic();
                dices = plusminuslogic.GetValidDices(player);
                break;
            case STRAIGHT:
                StraightLogic straigthlogic = new StraightLogic();
                dices = straigthlogic.GetValidDices(player);
                break;
        }
        return dices;
        /* return a valid dice list of each type of card
        -if the length of the dice is 6: Tutto / Straight Tutto;
        -if the length of the dice is 0: Null;
        -if the length of the dice is 12: Cloverleaf (2Tutto) / Fireworks
        -if the length of the dice is others:
           either a Fireworks
           or end in the halfway (Bonus/Multiply Two)*/
    }

    private ArrayList<Player> GetHighestPlayer(ArrayList<Player> players) {
        ArrayList<Player> HighestPlayer= new ArrayList<>();
        int MaxScore = 0;
//        ArrayList<Player> SortedPlayers = new ArrayList<>();
//        players.sort(Comparator.comparing(Player::getScore));
        for (Player player: players) {
            if(player.getScore()>=MaxScore) {
                MaxScore = player.getScore();
            }
        }

        for (Player player2: players) {
            if(player2.getScore() == MaxScore){
                HighestPlayer.add(player2);
            }
        }
        return HighestPlayer;
    }

    public void GameOn() {
        GenerateCardSet();
        for(int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player(input.getPlayers().get(i), 0);
            ListOfPlayers.add(player);
        }

        boolean Win = false;
        while(!Win) {
            for(Player player: ListOfPlayers) {
                Card card = DrawACard(); // a turn
                int ScoreInThisTurn = 0;
                ArrayList<Integer> resultdices = DicesOfThisCard(player, card);
                // Calculate the points gained in this card
                boolean Continue = true;
                while (Continue) {
                    int ScoreOfThisCard = 0;
                    switch (resultdices.size()){
                        case 0:
                            // if the card is STOP, return a empty list and enter this case
                            ScoreInThisTurn = 0;
                            Continue = false;
                            break;
                        case 6:
                            switch (card.GetCardType()) {
                                case BONUS:
                                    ScoreOfThisCard = Dices.CalDiceScores(resultdices) + card.GetPoints();
                                    break;
                                case MULTIPLY_TWO:
                                    ScoreOfThisCard = Dices.CalDiceScores(resultdices) * 2;
                                    break;
                                case STRAIGHT:
                                    ScoreOfThisCard = 2000;
                                    break;
                                case PLUS_MINUS:
                                    ScoreOfThisCard = 1000;
                                    ArrayList<Player> HighestPlayer = GetHighestPlayer(ListOfPlayers);
                                    for(Player player2: HighestPlayer) {
                                        if(player2 != player) {
                                            player2.setScore(player2.getScore()-1000);
                                        }
                                    }
                                    break;
                            }
                            String option = Logic.TuttoOption();
                            switch (option) {
                                case "E":
                                    Continue = false;
                                    break;
                                case "R":
                                    Card NewCard = DrawACard();
                                    resultdices = DicesOfThisCard(player, NewCard);
                                    break;
                            }
                            break;
                        case 12:
                            switch (card.GetCardType()) {
                                case CLOVERLEAF:
                                    ScoreOfThisCard = input.GetWinningPoints();
                                    break;
                                case FIREWORKS:
                                    ScoreOfThisCard = Dices.CalDiceScores(resultdices);
                                    break;
                            }
                            Continue = false;
                            break;
                        default:
                            ScoreOfThisCard = Dices.CalDiceScores(resultdices);
                            break;
                        }
                    ScoreInThisTurn += ScoreOfThisCard;
                }
                player.setScore(ScoreInThisTurn);
                if(player.getScore()>=input.GetWinningPoints()) {
                    System.out.println("Game over!");
                    System.out.println("Player"+player.name+"is the winner!");
                    Win = true;
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
            Card Bonus = new BonusCard(200);
            CardSet.add(Bonus);
        }
        for (int i = 0; i < 5; i++) {
            Card Bonus = new BonusCard(300);
            CardSet.add(Bonus);
        }
        for (int i = 0; i < 5; i++) {
            Card Bonus = new BonusCard(400);
            CardSet.add(Bonus);
        }
        for (int i = 0; i < 5; i++) {
            Card Bonus = new BonusCard(500);
            CardSet.add(Bonus);
        }
        for (int i = 0; i < 5; i++) {
            Card Bonus = new BonusCard(600);
            CardSet.add(Bonus);
        }
        for (int i = 0; i < 5; i++) {
            Card MultiplyTwo = new MultiplyTwoCard();
            CardSet.add(MultiplyTwo);
        }
        for (int i = 0; i < 10; i++) {
            Card Stop = new StopCard();
            CardSet.add(Stop);
        }
        for (int i = 0; i < 5; i++) {
            Card FireWorks = new FireworksCard();
            CardSet.add(FireWorks);
        }
        for (int i = 0; i < 5; i++) {
            Card Plus_Minus = new PlusMinusCard();
            CardSet.add(Plus_Minus);
        }
        Card CloverLeaf = new CloverleafCard();
        CardSet.add(CloverLeaf);

        for (int i = 0; i < 5; i++) {
            Card Straight = new StraightCard();
            CardSet.add(Straight);
        }
        Collections.shuffle(CardSet);
    }

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

    //Logic logic = new Logic();


}
