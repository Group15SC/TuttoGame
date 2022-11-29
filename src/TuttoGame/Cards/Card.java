package TuttoGame.Cards;

public class Card {
    public CardType CardType;
    public int Points;

    public Card(CardType cardType, int points) {
        this.CardType = cardType;
        this.Points = points;
    }
}
