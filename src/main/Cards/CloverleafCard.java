package main.Cards;

import main.GameController.Game;
import main.GameController.GameInitialization;
import main.Logics.CloverleafLogic;
import main.Logics.Dices;

import java.util.ArrayList;

public class CloverleafCard implements Card{

    Game game = new Game();

    @Override
    public CardType getCardType() {
        return CardType.CLOVERLEAF;
    }

    @Override
    public ArrayList<Integer> handleTurn() {
        CloverleafLogic cloverleaf = new CloverleafLogic(new Dices());
        cloverleaf.getValidDices();
        return cloverleaf.getKeptDices();
    }

    @Override
    public int calScores(ArrayList<Integer> keptDices) {
        int Score = Dices.calScoresOfDices(keptDices);
        if(keptDices.size() == 12){
            Score = 100000000; // accomplish a Tutto --> the Player wins
        }
        return Score;
    }

}
