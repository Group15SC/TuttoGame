package main.Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StopCardTest {

    @Test
    void getCardType() {
        StopCard stop = new StopCard();
        assertEquals(stop.GetCardType(), CardType.STOP);
    }

    @Test
    void getPoints() {
        StopCard stop = new StopCard();
        assertEquals(stop.GetPoints(), 0);
    }
}