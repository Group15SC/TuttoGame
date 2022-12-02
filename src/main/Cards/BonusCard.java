package main.Cards;

import java.util.ArrayList;

import main.Logics.BonusLogic;
import main.Logics.Dices;

public class BonusCard implements Card {
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
    public ArrayList<Integer> HandleTurn() {
        BonusLogic bonus = new BonusLogic(new Dices());
        bonus.GetValidDices();
        return bonus.getKeptDices();
    }


    @Override
    public int CalculateScore(ArrayList<Integer> keptDices) {
        int Score = CalculateScore(keptDices);
        if(keptDices.size()==6){
            Score += Points; // accomplish a Tutto --> get dices score+the points of this card
        }
        return Score;
    }

}
