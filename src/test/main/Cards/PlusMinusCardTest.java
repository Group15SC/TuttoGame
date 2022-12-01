package main.Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlusMinusCardTest {

    @Test
    void getCardType() {
        PlusMinusCard plusMinusCard = new PlusMinusCard();
        assertEquals(plusMinusCard.GetCardType(), CardType.PLUS_MINUS);
    }

    @Test
    void getPoints() {
        PlusMinusCard plusMinusCard = new PlusMinusCard();
        assertEquals(plusMinusCard.GetPoints(), 0);
    }
}