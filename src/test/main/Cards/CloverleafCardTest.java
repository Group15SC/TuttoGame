package main.Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CloverleafCardTest {

    @Test
    void getCardType() {
        CloverleafCard cloverleaf = new CloverleafCard();
        assertEquals(cloverleaf.GetCardType(), CardType.CLOVERLEAF);
    }

    @Test
    void getPoints() {
        CloverleafCard cloverleaf = new CloverleafCard();
        assertEquals(cloverleaf.GetPoints(), 0);
    }
}