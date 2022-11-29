package TuttoGame.Cards;

public class BonusCard extends Card{
    int Points;

    public BonusCard(int Points){
        this.Points = Points;
    }
    @Override
    public CardType GetCardType() {
        return CardType.BONUS;
    }

    public int GetPoints() {
        return Points;
    }

}
