package main.Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireworksCardTest {

    @Test
    void getCardType() {
        FireworksCard fireworks = new FireworksCard();
        assertEquals(fireworks.GetCardType(), CardType.FIREWORKS);
    }

    @Test
    void getPoints() {
        FireworksCard fireworks = new FireworksCard();
        assertEquals(fireworks.GetPoints(), 0);
    }
}