package main.Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusCardTest {

    @Test
    void getCardType() {
        BonusCard bonus = new BonusCard(200);
        assertEquals(bonus.GetCardType(), CardType.BONUS);
    }

    @Test
    void getPoints() {
        BonusCard bonus = new BonusCard(200);
        assertEquals(bonus.GetPoints(), 200);
    }
}