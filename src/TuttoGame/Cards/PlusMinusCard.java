package TuttoGame.Cards;

public class PlusMinusCard extends Card{
    @Override
    public CardType GetCardType() {
        return CardType.PLUS_MINUS;
    }

    @Override
    public int GetPoints() {
        return 0;
    }
}
