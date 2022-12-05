package main.Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StopCardTest {
    StopCard stop = new StopCard();

    @Test
    void getCardType() {
        assertEquals(CardType.STOP, stop.getCardType());
    }

    @Test
    void testNoDices(){
        assertTrue(stop.handleTurn().isEmpty());
    }


    @Test
    void testCalScore(){
        assertEquals(0, stop.calScores(stop.handleTurn()));
    }

    @Test
    void testDrawAnotherCard(){
        assertFalse(stop.ableToDrawAnotherCard());
    }

}