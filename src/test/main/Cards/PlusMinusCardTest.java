package main.Cards;

import main.GameController.Player;
import main.Logics.PlusMinusLogic;
import main.Logics.RollDice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlusMinusCardTest {

    PlusMinusCard plusMinusCard = new PlusMinusCard();

    @Test
    void getCardType() {
        assertEquals(CardType.PLUS_MINUS, plusMinusCard.getCardType());
    }

    @Test
    void testNotTuttoScore(){
        assertEquals(0, plusMinusCard.calScores(new ArrayList<>()));
    }

    @Test
    void testDrawAnotherCard(){
        assertFalse(plusMinusCard.ableToDrawAnotherCard());
    }

}