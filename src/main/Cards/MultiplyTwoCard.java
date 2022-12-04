package main.Cards;

import main.Logics.Dices;
import main.Logics.MultiplyTwoLogic;

import java.util.ArrayList;

public class MultiplyTwoCard implements Card{

    @Override
    public CardType getCardType() {
        return CardType.MULTIPLY_TWO;
    }


    @Override
    public ArrayList<Integer> handleTurn() {
        MultiplyTwoLogic multiplyTwoLogic = new MultiplyTwoLogic(new Dices());
        multiplyTwoLogic.getValidDices();
        return multiplyTwoLogic.getKeptDices();
    }

    @Override
    public int calScores(ArrayList<Integer> keptDices) {
        int Score = 2 * Dices.calScoresOfDices(keptDices);
        return Score;
    }
}
