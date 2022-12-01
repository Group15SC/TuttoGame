package main.Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StopCardTest {

    @Test
    void getCardType() {
        StopCard stop = new StopCard();
        assertEquals(CardType.STOP, stop.GetCardType());
    }

    @Test
    void getPoints() {
        StopCard stop = new StopCard();
        assertEquals(0, stop.GetPoints());
    }
}