package main.Cards;

import main.Logics.PlusMinusLogic;

import java.util.ArrayList;

public class PlusMinusCard extends Card{
    @Override
    public CardType GetCardType() {
        return CardType.PLUS_MINUS;
    }

    @Override
    public int GetPoints() {
        return 0;
    }

    @Override
    public ArrayList<Integer> ValidDices() {
        PlusMinusLogic PlusMinus = new PlusMinusLogic();
        return PlusMinus.GetValidDices();
    }
}
