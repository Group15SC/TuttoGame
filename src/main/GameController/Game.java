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

    public static String askForContinueOption(Player player, String option) {
        while(!option.equals("R")) {
            switch (option) {
                // choosing display: display current score
                case "D" -> System.out.println(player.getScore());
                case "E" -> System.out.println("You may not end now! Please re-enter:");
                default -> System.out.println("Invalid Input! Please input again");
            }
            option = UI.turnStartingOption();
        }
        return option;
    }

    private static void displayScoreForEachPlayer(ArrayList<Player> players) {
        for(Player player: players){
            System.out.println("Player "+player.getName()+" got "+player.getScore()+" in total");
        }
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
        while(!Win) {
            for(Player player: listOfPlayers) {
                Card card = drawACard(deck); // a turn
                System.out.println("Player "+player.getName());
                System.out.println("The card you got is: " + card.getCardType());
                // get the bonus points of this bonus card
                if(!(card instanceof StopCard)) {
                    if(card instanceof BonusCard bonusCard) {
                        System.out.println("The bonus points of this card is " + bonusCard.getPoints());
                    }
                    int ScoreInThisTurn = 0; // the actual score gained in this turn
                    String option = UI.turnStartingOption();
                    option = askForContinueOption(player, option);
                    handleAPlayersTurn(deck, player, card, ScoreInThisTurn, option); // handle a player's turn
                }
                System.out.println("Your turn is over!");
                System.out.println("============================");
                if(player.getScore() >= WinningPoints) {
                    System.out.println("Game over!");
                    System.out.println("Player "+player.getName()+" is the winner!");
                    displayScoreForEachPlayer(listOfPlayers);
                    Win = true;
                    break;
                }
            }
        }
    }

    private void handleAPlayersTurn(ArrayList<Card> deck, Player player, Card card, int ScoreInThisTurn, String option) {
        if (option.equals("R")) {
            ArrayList<Integer> ResultDices = card.handleTurn();
            // Calculate the points gained in this card
            boolean Continue = true;
            int ScoreOfThisCard = 0;
            while (Continue) {
                ScoreOfThisCard = card.calScores(ResultDices);
                // store the score gained with this card
                if (card.getCardType() == CardType.STOP) {
                    Continue = false;
                }
                if (card.getCardType() == CardType.PLUS_MINUS && card.ableToDrawAnotherCard()) {
                    // the player is able to draw a new card if and only if accomplishing a Tutto
                    ArrayList<Player> HighestPlayer = getHighestPlayer(listOfPlayers);
                    for (Player player2 : HighestPlayer) {
                        if (player2 != player) {
                            player2.setScore(player2.getScore() - 1000);
                        }
                    }
                }
                if (card.ableToDrawAnotherCard()) { // if the player wants to draw a new card after Tutto
                    String ifContinue = UI.tuttoOption();
                    switch (ifContinue) {
                        case "E" -> Continue = false; // end this turn
                        case "R" -> {
                            Card NewCard = drawACard(deck);
                            System.out.println("Player " + player.getName());
                            System.out.println("The card you got is: " + card.getCardType());
                            ResultDices = NewCard.handleTurn();
                        }
                    }
                } else { // if not able to draw another card --> setScore and end this turn
                    Continue = false; // end this turn
                }
            }
            ScoreInThisTurn += ScoreOfThisCard;
            player.setScore(ScoreInThisTurn);
            System.out.println("The score you obtained in this turn is: "+ ScoreInThisTurn);
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




//                            switch (ResultDices.size()){
//                                case 0:
//                                    // if the card is STOP, return an empty list and enter this case
//                                    ScoreInThisTurn = 0;
//                                    Continue = false;
//                                    break;
//                                case 6:
//                                case 12:
//                                    switch (card.getCardType()) {
//                                        case BONUS:
//                                        case MULTIPLY_TWO:
//                                        case STRAIGHT:
//                                        case CLOVERLEAF:
//                                        case FIREWORKS:
//                                            ScoreOfThisCard = card.calScores(ResultDices);
//                                            break;
//                                        case PLUS_MINUS:
//                                            ScoreOfThisCard = card.calScores(ResultDices);
//                                            ArrayList<Player> HighestPlayer = getHighestPlayer(listOfPlayers);
//                                            for(Player player2: HighestPlayer) {
//                                                if(player2 != player) {
//                                                    player2.setScore(player2.getScore()-1000);
//                                                }
//                                            }
//                                            break;
//                                    }
//                                    String ifContinue = UI.tuttoOption();
//                                    switch (ifContinue) {
//                                        case "E":
//                                            Continue = false;
//                                            break;
//                                        case "R":
//                                            Card NewCard = drawACard(deck);
//                                            ResultDices = NewCard.handleTurn();
//                                            break;
//                                    }
//                                    break;
//                                default:
//                                    ScoreOfThisCard = Dices.calScoresOfDices(ResultDices);
//                                    Continue = false;
//                                    break;
//                            }
//                            ScoreInThisTurn += ScoreOfThisCard;
//                        }
//                        player.setScore(ScoreInThisTurn);
//                    }
//
//                System.out.println("Your turn is over!");
//                System.out.println("============================");


