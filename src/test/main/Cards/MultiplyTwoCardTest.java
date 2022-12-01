package main.Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyTwoCardTest {

    @Test
    void getCardType() {
        MultiplyTwoCard multiplyTwoCard = new MultiplyTwoCard();
        assertEquals(CardType.MULTIPLY_TWO, multiplyTwoCard.GetCardType());
    }

    @Test
    void getPoints() {
        MultiplyTwoCard multiplyTwoCard = new MultiplyTwoCard();
        assertEquals(0, multiplyTwoCard.GetPoints());
    }
}