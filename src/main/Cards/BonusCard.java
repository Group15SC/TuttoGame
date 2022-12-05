package main.Cards;

import java.util.ArrayList;

import main.Logics.BonusLogic;
import main.Logics.Dices;

public class BonusCard implements Card {
    private int points;
    private boolean isTutto = false;

    public BonusCard(int Points){
        this.points = Points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public CardType getCardType() {
        return CardType.BONUS;
    }

    @Override
    public ArrayList<Integer> handleTurn() {
        BonusLogic bonus = new BonusLogic(new Dices());
        bonus.getValidDices();
        isTutto = bonus.isTutto();
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

    @Override
    public boolean ableToDrawAnotherCard() {
        return isTutto; //--> if accomplish a Tutto, the player is able to draw a new card and continue
    }
}
