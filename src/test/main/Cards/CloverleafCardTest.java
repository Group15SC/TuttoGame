package main.Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CloverleafCardTest {

    @Test
    void getCardType() {
        CloverleafCard cloverleaf = new CloverleafCard();
        assertEquals(CardType.CLOVERLEAF, cloverleaf.GetCardType());
    }

    @Test
    void getPoints() {
        CloverleafCard cloverleaf = new CloverleafCard();
        assertEquals(0, cloverleaf.GetPoints());
    }
}