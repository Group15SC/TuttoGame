package main.Cards;

import main.Logics.BonusLogic;
import main.Logics.Dices;
import main.Logics.FireworksLogic;

import java.util.ArrayList;

public class FireworksCard implements Card{
    @Override
    public CardType getCardType() {
        return CardType.FIREWORKS;
    }

//    @Override
//    public int GetPoints() {
//        return 0;
//    }

    @Override
    public ArrayList<Integer> handleTurn() {
        FireworksLogic fireworksLogic = new FireworksLogic(new Dices());
        fireworksLogic.getValidDices();
        return fireworksLogic.getKeptDices();
    }

    @Override
    public int calScores(ArrayList<Integer> keptDices) {
        int Score = Dices.calScoresOfDices(keptDices);
        return Score;
    }

    @Override
    public boolean ableToDrawAnotherCard() {
        return false; //--> Fireworks card cannot continue to draw another card after accomplishing a Tutto
    }

}
