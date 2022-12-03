package main.Cards;

import java.util.ArrayList;

import main.Logics.BonusLogic;
import main.Logics.Dices;

public class BonusCard implements Card {
    int points;

    public BonusCard(int Points){
        this.points = Points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public CardType GetCardType() {
        return CardType.BONUS;
    }

    @Override
    public ArrayList<Integer> HandleTurn() {
        BonusLogic bonus = new BonusLogic(new Dices());
        bonus.getValidDices();
        return bonus.getKeptDices();
    }


    @Override
    public int calScores(ArrayList<Integer> keptDices) {
        int Score = Dices.calScoresOfDices(keptDices);
        if(keptDices.size() == 6){
            Score += points; // accomplish a Tutto --> get dices score+the points of this card
        }
        return Score;
    }

}
