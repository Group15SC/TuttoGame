package main.Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StraightCardTest {

    @Test
    void getCardType() {
        StraightCard straightCard = new StraightCard();
        assertEquals(straightCard.GetCardType(), CardType.STRAIGHT);
    }

    @Test
    void getPoints() {
        StraightCard straightCard = new StraightCard();
        assertEquals(straightCard.GetPoints(), 0);
    }
}