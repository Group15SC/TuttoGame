package TuttoGame.Cards;

public class StraightCard extends Card{
    @Override
    public CardType GetCardType() {
        return CardType.STRAIGHT;
    }

    @Override
    public int GetPoints() {
        return 0;
    }
}
