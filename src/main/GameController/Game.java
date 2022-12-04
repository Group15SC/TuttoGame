package main.GameController;

import main.Cards.*;
import main.Logics.Dices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);


    ArrayList<Player> listOfPlayers = new ArrayList<>();

    public Game() {}

    private static Card drawACard(ArrayList<Card> CardSet) {
        // the card pile if empty, so start again from generating a shuffled card set
        if(CardSet.size()==0){
            generateCardSet();
        }
        Card card = CardSet.get(CardSet.size() - 1);
        CardSet.remove(CardSet.size() - 1);
        return card;
    }

    private static ArrayList<Player> getHighestPlayer(ArrayList<Player> players) {
        ArrayList<Player> HighestPlayer= new ArrayList<>();
        int MaxScore = 0;
//        ArrayList<Player> SortedPlayers = new ArrayList<>();
//        players.sort(Comparator.comparing(Player::getScore));
        for (Player player: players) {
            if(player.getScore() >= MaxScore) {
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

    public void gameOn() {
        //Game Initialization: Setup Players and generate a deck of cards
        ArrayList<Card> deck = generateCardSet();
        GameInitialization gameInitialization = new GameInitialization();
        ArrayList<String> players;
        int numberOfPlayers = gameInitialization.getNumberOfPlayers();
        players = gameInitialization.getPlayers();
        int WinningPoints = gameInitialization.getWinningPoints();
        for(int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player(players.get(i), 0);
            listOfPlayers.add(player);
        }

        boolean Win = false;
        while(Win == false) {
            for(Player player: listOfPlayers) {
                Card card = drawACard(deck); // a turn
                System.out.println("Player "+player.getName());
                System.out.println("The card you got is: " + card.getCardType());
                // get the bonus points of this bonus card
                if(card instanceof BonusCard) {
                    BonusCard bonusCard = (BonusCard) card;
                    System.out.println("The bonus points of this card is " + bonusCard.getPoints());
                }
                if (card.getCardType() != CardType.STOP) {
                    int ScoreInThisTurn = 0;
                    String option = UI.turnStartingOption();
                    while(!option.equals("R")) {
                        switch (option) {
                            // choosing display: display current score
                            case "D":
                                System.out.println(player.getScore());
                                break;
                            case "E":
                                System.out.println("You may not end now! Please re-enter:");
                                break;
                            default:
                                System.out.println("Invalid Input! Please input again");
                                break;
                        }
                        option = UI.turnStartingOption();
                    }
                    if (option.equals("R")) {
                        ArrayList<Integer> ResultDices = card.handleTurn();
                        // Calculate the points gained in this card
                        boolean Continue = true;
                        while (Continue) {
                            int ScoreOfThisCard = 0;
                            switch (ResultDices.size()){
                                case 0:
                                    // if the card is STOP, return an empty list and enter this case
                                    ScoreInThisTurn = 0;
                                    Continue = false;
                                    break;
                                case 6:
                                case 12:
                                    switch (card.getCardType()) {
                                        case BONUS:
                                        case MULTIPLY_TWO:
                                        case STRAIGHT:
                                        case CLOVERLEAF:
                                        case FIREWORKS:
                                            ScoreOfThisCard = card.calScores(ResultDices);
                                            break;
                                        case PLUS_MINUS:
                                            ScoreOfThisCard = card.calScores(ResultDices);
                                            ArrayList<Player> HighestPlayer = getHighestPlayer(listOfPlayers);
                                            for(Player player2: HighestPlayer) {
                                                if(player2 != player) {
                                                    player2.setScore(player2.getScore()-1000);
                                                }
                                            }
                                            break;
                                    }
                                    String ifContinue = UI.tuttoOption();
                                    switch (ifContinue) {
                                        case "E":
                                            Continue = false;
                                            break;
                                        case "R":
                                            Card NewCard = drawACard(deck);
                                            ResultDices = NewCard.handleTurn();
                                            break;
                                    }
                                    break;
                                default:
                                    ScoreOfThisCard = Dices.calScoresOfDices(ResultDices);
                                    Continue = false;
                                    break;
                            }
                            ScoreInThisTurn += ScoreOfThisCard;
                        }
                        player.setScore(ScoreInThisTurn);
                    }
                }
                System.out.println("Your turn is over!");
                System.out.println("============================");
                if(player.getScore() >= WinningPoints) {
                    System.out.println("Game over!");
                    System.out.println("Player "+player.getName()+" is the winner!");
                    Win = true;
                    break;
                }
            }
        }
    }


    public static ArrayList<Card> generateCardSet(){
        ArrayList<Card> CardSet = new ArrayList<>();
        Card CloverLeaf = new CloverleafCard();
        for (int i = 0; i < 5; i++) {
//          add bonus cards, 200-600 points * 5
            for (int point = 2; point <= 6; point ++){
                CardSet.add(new BonusCard(point*100));
            }
            // add x2, fireworks, plus_minus, straight *5
            CardSet.add(new MultiplyTwoCard());
            CardSet.add(new FireworksCard());
            CardSet.add(new PlusMinusCard());
            CardSet.add(new StraightCard());
            // add stop *10
            CardSet.add(new StopCard());
            CardSet.add(new StopCard());
        }
        // add cloverleaf * 1
        CardSet.add(CloverLeaf);
        // shuffle the deck
        Collections.shuffle(CardSet);
        return CardSet;
    }
}





//        for (int i = 0; i < 5; i++) {
//            Card Bonus = new BonusCard(300);
//            CardSet.add(Bonus);
//        }
//        for (int i = 0; i < 5; i++) {
//            Card Bonus = new BonusCard(400);
//            CardSet.add(Bonus);
//        }
//        for (int i = 0; i < 5; i++) {
//            Card Bonus = new BonusCard(500);
//            CardSet.add(Bonus);
//        }
//        for (int i = 0; i < 5; i++) {
//            Card Bonus = new BonusCard(600);
//            CardSet.add(Bonus);
//        }
//        for (int i = 0; i < 5; i++) {
//              Card MultiplyTwo = new MultiplyTwoCard();
//              CardSet.add(MultiplyTwo);
//        }
//        for (int i = 0; i < 10; i++) {
//
//
//        }
//        for (int i = 0; i < 5; i++) {
//            Card FireWorks = new FireworksCard();
//            CardSet.add(FireWorks);
//        }
//        for (int i = 0; i < 5; i++) {
//            Card Plus_Minus = new PlusMinusCard();
//            CardSet.add(Plus_Minus);
//        }
//
//
//        for (int i = 0; i < 5; i++) {
//            Card Straight = new StraightCard();
//            CardSet.add(Straight);
//        }




//    private ArrayList<Integer> DicesOfThisCard(Card card){
//        ArrayList<Integer> dices = card.ValidDices();
//        switch (card.GetCardType()){
//            case STOP:
//                break;
//            case BONUS:
//                BonusLogic bonuslogic = new BonusLogic();
//                dices = bonuslogic.GetValidDices(player);
//                break;
//            case MULTIPLY_TWO:
//                MultiplyTwoLogic multiplytwologic = new MultiplyTwoLogic();
//                dices = multiplytwologic.GetValidDices(player);
//                break;
//            case FIREWORKS:
//                FireworksLogic fireworksLogic = new FireworksLogic();
//                dices = fireworksLogic.GetValidDices(player);
//                break;
//            case CLOVERLEAF:
//                CloverleafLogic cloverleaflogic = new CloverleafLogic();
//                dices = cloverleaflogic.GetValidDices(player);
//                break;
//            case PLUS_MINUS:
//                PlusMinusLogic plusminuslogic = new PlusMinusLogic();
//                dices = plusminuslogic.GetValidDices(player);
//                break;
//            case STRAIGHT:
//                StraightLogic straigthlogic = new StraightLogic();
//                dices = straigthlogic.GetValidDices(player);
//                break;
//        }
//        return dices;
        /* return a valid dice list of each type of card
        -if the length of the dice is 6: Tutto / Straight Tutto;
        -if the length of the dice is 0: Null;
        -if the length of the dice is 12: Cloverleaf (2Tutto) / Fireworks
        -if the length of the dice is others:
           either a Fireworks
           or end in the halfway (Bonus/Multiply Two)*/
    //}














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



