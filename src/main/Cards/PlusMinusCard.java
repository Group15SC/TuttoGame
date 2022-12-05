package main.Cards;

import main.Logics.BonusLogic;
import main.Logics.Dices;
import main.Logics.PlusMinusLogic;

import java.util.ArrayList;

public class PlusMinusCard implements Card{
    private boolean isTutto = false;

    @Override
    public CardType getCardType() {
        return CardType.PLUS_MINUS;
    }

    @Override
    public ArrayList<Integer> handleTurn() {
        PlusMinusLogic plusMinusLogic = new PlusMinusLogic(new Dices());
        plusMinusLogic.getValidDices();
        isTutto = plusMinusLogic.isTutto();
        return plusMinusLogic.getKeptDices();
    }

    @Override
    public int calScores(ArrayList<Integer> keptDices) {
        if(isTutto){
            return 1000;
        } else {
            return 0;
        }
    }

    @Override
    public boolean ableToDrawAnotherCard() {
        return isTutto; //--> if accomplish a Tutto, the player is able to draw a new card and continue
    }

}
