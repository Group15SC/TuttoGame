package main.Cards;

import main.Logics.Dices;
import main.Logics.StopLogic;

import java.util.ArrayList;

public class StopCard implements Card{

    @Override
    public CardType getCardType() {
        return CardType.STOP;
    }

//    @Override
//    public int GetPoints() {
//        return 0;
//    }

    @Override
    public ArrayList<Integer> handleTurn() {
        return new ArrayList<>(); //return an empty list
    }

    @Override
    public int calScores(ArrayList<Integer> keptDices) {
        return 0;
    }
}
