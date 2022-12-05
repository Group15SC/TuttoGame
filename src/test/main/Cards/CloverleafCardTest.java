package main.Cards;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class CloverleafCardTest {

    CloverleafCard cloverleaf = new CloverleafCard();

    @Test
    void getCardType() {
        assertEquals(CardType.CLOVERLEAF, cloverleaf.getCardType());
    }

    @Test
    void handleTurn() {
    }

    @Test
    void testFullScores() {
        int[] aCloverleaf = {1,1,1,2,2,2,3,3,3,4,4,4};
        ArrayList<Integer> aCase = new ArrayList<>();
        for(int dice: aCloverleaf){
            aCase.add(dice);
        }
        int actual = cloverleaf.calScores(aCase);
        assertEquals(100000000,actual);
    }

    @Test
    void ableToDrawAnotherCard() {
    }

    @Test
    void testDefaultIsTutto() {
        assertFalse(cloverleaf.isTutto());
    }
}