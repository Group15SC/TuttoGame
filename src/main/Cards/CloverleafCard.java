package main.Cards;

import main.Logics.CloverleafLogic;
import main.Logics.Logic;

import java.util.ArrayList;

public class CloverleafCard extends Card{

    @Override
    public CardType GetCardType() {
        return CardType.CLOVERLEAF;
    }

    @Override
    public int GetPoints() {
        return 0;
    }

    @Override
    public ArrayList<Integer> ValidDices() {
        Logic cloverleaf = new CloverleafLogic();
        return cloverleaf.GetValidDices();
    }

}
