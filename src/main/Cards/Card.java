package main.Cards;


import java.util.ArrayList;

public interface Card {
    CardType GetCardType();
//    int GetPoints();
    ArrayList<Integer> HandleTurn();
    int CalculateScore(ArrayList<Integer> keptDices);
}
