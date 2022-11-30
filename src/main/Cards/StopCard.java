package main.Cards;

import main.Logics.StopLogic;

import java.util.ArrayList;

public class StopCard extends Card{

    @Override
    public CardType GetCardType() {
        return CardType.STOP;
    }

    @Override
    public int GetPoints() {
        return 0;
    }

    @Override
    public ArrayList<Integer> ValidDices() {
        StopLogic stop = new StopLogic();
        return stop.GetValidDices();
    }
}
