package main.Cards;

import main.Logics.BonusLogic;
import main.Logics.Dices;
import main.Logics.FireworksLogic;

import java.util.ArrayList;

public class FireworksCard implements Card{
    @Override
    public CardType GetCardType() {
        return CardType.FIREWORKS;
    }

//    @Override
//    public int GetPoints() {
//        return 0;
//    }

    @Override
    public ArrayList<Integer> HandleTurn() {
        FireworksLogic fireworksLogic = new FireworksLogic(new Dices());
        fireworksLogic.getValidDices();
        return fireworksLogic.getKeptDices();
    }

    @Override
    public int calScores(ArrayList<Integer> keptDices) {
        int Score = Dices.calScoresOfDices(keptDices);
        return Score;
    }
}
