package main.Cards;

import main.Logics.CloverleafLogic;
import main.Logics.Logic;

import java.util.ArrayList;

public class CloverleafCard implements Card{

    @Override
    public CardType GetCardType() {
        return CardType.CLOVERLEAF;
    }

//    @Override
//    public int GetPoints() {
//        return 0;
//    }

    @Override
    public ArrayList<Integer> HandleTurn() {
        Logic cloverleaf = new CloverleafLogic();
        return cloverleaf.GetValidDices();
    }

    @Override
    public int CalculateScore(ArrayList<Integer> keptDices) {
        return 0;
    }

}
