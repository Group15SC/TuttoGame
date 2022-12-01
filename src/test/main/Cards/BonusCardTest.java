package main.Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusCardTest {

    @Test
    void getCardType() {
        BonusCard bonus = new BonusCard(200);
        assertEquals(CardType.BONUS, bonus.GetCardType());
    }

    @Test
    void getPoints() {
        BonusCard bonus = new BonusCard(200);
        assertEquals(200, bonus.GetPoints());
    }
}