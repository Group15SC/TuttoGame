package TuttoGame.Cards;

import TuttoGame.Logics.FireworksLogic;

import java.util.ArrayList;

public class FireworksCard extends Card{
    @Override
    public CardType GetCardType() {
        return CardType.FIREWORKS;
    }

    @Override
    public int GetPoints() {
        return 0;
    }

    @Override
    public ArrayList<Integer> ValidDices() {
        FireworksLogic fireworks = new FireworksLogic();
        return fireworks.GetValidDices();
    }
}
