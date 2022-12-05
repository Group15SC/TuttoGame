package main.Cards;

import main.GameController.Game;
import main.GameController.GameInitialization;
import main.Logics.CloverleafLogic;
import main.Logics.Dices;

import java.util.ArrayList;

public class CloverleafCard implements Card{
    private boolean isTutto = false;

    @Override
    public CardType getCardType() {
        return CardType.CLOVERLEAF;
    }

    @Override
    public ArrayList<Integer> handleTurn() {
        CloverleafLogic cloverleaf = new CloverleafLogic(new Dices());
        cloverleaf.getValidDices();
        isTutto = cloverleaf.isTutto();
        return cloverleaf.getKeptDices();
    }

    @Override
    public int calScores(ArrayList<Integer> keptDices) {
        int Score = 0;
        if(keptDices.size() == 12){
            Score = 100000000; // accomplish a Tutto --> the Player wins
        }
        return Score;
    }
    @Override
    public boolean ableToDrawAnotherCard() {
        return false; //--> if accomplish a Tutto, the game comes to an end, no need to draw a new card
    }

    public boolean isTutto() {
        return isTutto;
    }
}
