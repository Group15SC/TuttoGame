package main.Cards;


import java.util.ArrayList;

public interface Card {
    CardType getCardType();
    ArrayList<Integer> handleTurn();
    int calScores(ArrayList<Integer> keptDices);
}
