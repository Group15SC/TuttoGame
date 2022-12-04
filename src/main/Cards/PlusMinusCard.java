package main.Cards;

import main.Logics.BonusLogic;
import main.Logics.Dices;
import main.Logics.PlusMinusLogic;

import java.util.ArrayList;

public class PlusMinusCard implements Card{
    @Override
    public CardType getCardType() {
        return CardType.PLUS_MINUS;
    }


    @Override
    public ArrayList<Integer> handleTurn() {
        PlusMinusLogic plusMinusLogic = new PlusMinusLogic(new Dices());
        plusMinusLogic.getValidDices();
        return plusMinusLogic.getKeptDices();
    }

    @Override
    public int calScores(ArrayList<Integer> keptDices) {
        return 1000;
    }


}
