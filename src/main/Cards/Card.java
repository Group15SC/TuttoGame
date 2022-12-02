package main.Cards;


import java.util.ArrayList;

interface Card {
    CardType GetCardType();
    int GetPoints();
    ArrayList<Integer> ValidDices();

}
