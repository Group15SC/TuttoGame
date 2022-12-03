package main.Cards;

import main.GameController.GameInitialization;
import main.Logics.CloverleafLogic;
import main.Logics.Dices;

import java.util.ArrayList;

public class CloverleafCard implements Card{

    @Override
    public CardType GetCardType() {
        return CardType.CLOVERLEAF;
    }

    @Override
    public ArrayList<Integer> HandleTurn() {
        CloverleafLogic cloverleaf = new CloverleafLogic(new Dices());
        cloverleaf.getValidDices();
        return cloverleaf.getKeptDices();
    }
    GameInitialization gameInitialization = new GameInitialization();

    @Override
    public int calScores(ArrayList<Integer> keptDices) {
        int Score = Dices.calScoresOfDices(keptDices);
        if(keptDices.size() == 12){
            Score = gameInitialization.GetWinningPoints(); // accomplish a Tutto --> the Player wins
        }
        return Score;
    }

}
