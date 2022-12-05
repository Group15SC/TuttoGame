package main.Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireworksCardTest {

    @Test
    void getCardType() {
        FireworksCard fireworks = new FireworksCard();
        assertEquals(CardType.FIREWORKS, fireworks.getCardType());
    }

//    @Test
//    void getPoints() {
//        FireworksCard fireworks = new FireworksCard();
//        assertEquals(0, fireworks.getPoints());
//    }
}