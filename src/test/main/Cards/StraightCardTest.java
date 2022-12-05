package main.Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StraightCardTest {

    @Test
    void getCardType() {
        StraightCard straightCard = new StraightCard();
        assertEquals(CardType.STRAIGHT, straightCard.getCardType());
    }

//    @Test
//    void getPoints() {
//        StraightCard straightCard = new StraightCard();
//        assertEquals(0, straightCard.GetPoints());
//    }
}