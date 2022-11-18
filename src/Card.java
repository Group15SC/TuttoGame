import java.util.ArrayList;
import java.util.Collections;

public class Card {
    CardType CardType;
    int AddScore;
    public Card(CardType cardType, int addScore) {
        this.CardType = cardType;
        this.AddScore = addScore;
    }

    public ArrayList<Card> GenerateCardSet(){

        ArrayList<Card> CardSet = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Card Bonus = new Card(CardType.BONUS, 200);
            CardSet.add(Bonus);
        }
        for (int i = 0; i < 5; i++) {
            Card Bonus = new Card(CardType.BONUS, 300);
            CardSet.add(Bonus);
        }
        for (int i = 0; i < 5; i++) {
            Card Bonus = new Card(CardType.BONUS, 400);
            CardSet.add(Bonus);
        }
        for (int i = 0; i < 5; i++) {
            Card Bonus = new Card(CardType.BONUS, 500);
            CardSet.add(Bonus);
        }
        for (int i = 0; i < 5; i++) {
            Card Bonus = new Card(CardType.BONUS, 600);
            CardSet.add(Bonus);
        }
        for (int i = 0; i < 5; i++) {
            Card MultiplyTwo = new Card(CardType.MULTIPLY_TWO, 0);
            CardSet.add(MultiplyTwo);
        }
        for (int i = 0; i < 10; i++) {
            Card Stop = new Card(CardType.STOP, 0);
            CardSet.add(Stop);
        }
        for (int i = 0; i < 5; i++) {
            Card FireWorks = new Card(CardType.FIREWORKS, 0);
            CardSet.add(FireWorks);
        }
        for (int i = 0; i < 5; i++) {
            Card Plus_Minus = new Card(CardType.PLUS_MINUS, 0);
            CardSet.add(Plus_Minus);
        }
        Card CloverLeaf = new Card(CardType.CLOVERLEAF, 0);
        CardSet.add(CloverLeaf);

        for (int i = 0; i < 5; i++) {
            Card Straight = new Card(CardType.STRAIGHT, 0);
            CardSet.add(Straight);
        }
        Collections.shuffle(CardSet);
        return CardSet;
    }


}
