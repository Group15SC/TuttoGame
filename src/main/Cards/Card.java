package main.Cards;


import java.util.ArrayList;

public abstract class Card {
    public abstract CardType GetCardType();
    public abstract int GetPoints();
    public abstract ArrayList<Integer> ValidDices();

}
