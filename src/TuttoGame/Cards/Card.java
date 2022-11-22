package TuttoGame.Cards;

public class Card {
    public CardType CardType;
    public int AddScore;

    public Card(CardType cardType, int addScore) {
        this.CardType = cardType;
        this.AddScore = addScore;
    }
}
