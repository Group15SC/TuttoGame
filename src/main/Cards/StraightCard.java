package main.Cards;

import main.Logics.BonusLogic;
import main.Logics.Dices;
import main.Logics.StraightLogic;

import java.util.ArrayList;

public class StraightCard implements Card{
    @Override
    public CardType getCardType() {
        return CardType.STRAIGHT;
    }

    @Override
    public ArrayList<Integer> handleTurn() {
        StraightLogic straightLogic= new StraightLogic(new Dices());
        straightLogic.getValidDices();
        return straightLogic.getKeptDices();
    }

    @Override
    public int calScores(ArrayList<Integer> keptDices) {
        return 2000;
    }
}
