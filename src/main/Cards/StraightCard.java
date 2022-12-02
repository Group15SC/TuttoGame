package main.Cards;

import main.Logics.StraightLogic;

import java.util.ArrayList;

public class StraightCard implements Card{
    @Override
    public CardType GetCardType() {
        return CardType.STRAIGHT;
    }

    @Override
    public int GetPoints() {
        return 0;
    }

    @Override
    public ArrayList<Integer> ValidDices() {
        StraightLogic straight = new StraightLogic();
        return straight.GetValidDices();
    }
}
