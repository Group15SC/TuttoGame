package main.Cards;

import java.util.ArrayList;

import main.Logics.BonusLogic;

public class BonusCard extends Card {
    int Points;

    public BonusCard(int Points){
        this.Points = Points;
    }
    @Override
    public CardType GetCardType() {
        return CardType.BONUS;
    }

    public int GetPoints() {
        return Points;
    }

    @Override
    public ArrayList<Integer> ValidDices() {
        BonusLogic bonus = new BonusLogic();
        return bonus.GetValidDices();
    }
}
