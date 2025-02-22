package main.Cards;

import main.Logics.Dices;
import main.Logics.MultiplyTwoLogic;

import java.util.ArrayList;

public class MultiplyTwoCard implements Card{

    private boolean isTutto = false;
    @Override
    public CardType getCardType() {
        return CardType.MULTIPLY_TWO;
    }

    @Override
    public ArrayList<Integer> handleTurn() {
        MultiplyTwoLogic multiplyTwoLogic = new MultiplyTwoLogic(new Dices());
        multiplyTwoLogic.getValidDices();
        isTutto = multiplyTwoLogic.isTutto();
        return multiplyTwoLogic.getKeptDices();
    }

    @Override
    public int calScores(ArrayList<Integer> keptDices) {
        int Score = Dices.calScoresOfDices(keptDices);
        if(keptDices.size() == 6){
            Score = Score*2; // accomplish a Tutto --> get dices score+the points of this card
        }
        return Score;
    }

    @Override
    public boolean ableToDrawAnotherCard() {
        return isTutto; //--> if accomplish a Tutto, the player is able to draw a new card and continue
    }

}
