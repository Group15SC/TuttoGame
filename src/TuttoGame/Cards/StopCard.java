package TuttoGame.Cards;

public class StopCard extends Card{

    @Override
    public CardType GetCardType() {
        return CardType.STOP;
    }

    @Override
    public int GetPoints() {
        return 0;
    }
}
