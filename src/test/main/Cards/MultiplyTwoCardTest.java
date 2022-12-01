package main.Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyTwoCardTest {

    @Test
    void getCardType() {
        MultiplyTwoCard multiplyTwoCard = new MultiplyTwoCard();
        assertEquals(multiplyTwoCard.GetCardType(), CardType.MULTIPLY_TWO);
    }

    @Test
    void getPoints() {
        MultiplyTwoCard multiplyTwoCard = new MultiplyTwoCard();
        assertEquals(multiplyTwoCard.GetPoints(), 0);
    }
}