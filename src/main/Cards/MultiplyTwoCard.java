package main.Cards;

import main.Logics.MultiplyTwoLogic;

import java.util.ArrayList;

public class MultiplyTwoCard extends Card{

    @Override
    public CardType GetCardType() {
        return CardType.MULTIPLY_TWO;
    }

    @Override
    public int GetPoints() {
        return 0;
    }

    @Override
    public ArrayList<Integer> ValidDices() {
        MultiplyTwoLogic MultiplyTwo = new MultiplyTwoLogic();
        return MultiplyTwo.GetValidDices();
    }
}
