package main.Cards;

import main.Logics.BonusLogic;
import main.Logics.Dices;
import main.Logics.StraightLogic;

import java.util.ArrayList;

public class StraightCard implements Card{
    private boolean isTutto = false;

    public boolean isTutto() {
        return isTutto;
    }

    @Override
    public CardType getCardType() {
        return CardType.STRAIGHT;
    }

    @Override
    public ArrayList<Integer> handleTurn() {
        StraightLogic straightLogic= new StraightLogic(new Dices());
        straightLogic.getValidDices();
        isTutto = straightLogic.isTutto();
        return straightLogic.getKeptDices();
    }

    @Override
    public int calScores(ArrayList<Integer> keptDices) {
        if(keptDices.size()==6){
            return 2000;
        }
        else{
            return 0;
        }
    }

    @Override
    public boolean ableToDrawAnotherCard() {
        return isTutto; //--> if accomplish a Tutto, the player is able to draw a new card and continue
    }

}
