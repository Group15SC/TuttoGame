package main.Cards;

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
        FireworksLogic fireworks = new FireworksLogic();
        return fireworks.GetValidDices();
    }

    @Override
    public int CalculateScore(ArrayList<Integer> keptDices) {
        return 0;
    }
}
