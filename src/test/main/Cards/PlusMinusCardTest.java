package main.Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlusMinusCardTest {

    @Test
    void getCardType() {
        PlusMinusCard plusMinusCard = new PlusMinusCard();
        assertEquals(CardType.PLUS_MINUS, plusMinusCard.GetCardType());
    }

    @Test
    void getPoints() {
        PlusMinusCard plusMinusCard = new PlusMinusCard();
        assertEquals(0, plusMinusCard.GetPoints());
    }
}