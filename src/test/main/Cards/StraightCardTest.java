package main.Cards;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StraightCardTest {

    StraightCard straight = new StraightCard();

    @Test
    void getCardType() {
        StraightCard straightCard = new StraightCard();
        assertEquals(CardType.STRAIGHT, straightCard.getCardType());
    }

    @Test
    void tesTuttoScore() {
        int[] aCase = {1,2,3,4,5,6};
        ArrayList<Integer> tutto = new ArrayList<>();
        for(int dice: aCase){
            tutto.add(dice);
        }
        assertEquals(2000, straight.calScores(tutto));
    }

    @Test
    void testNoScore() {
        int[] aCase = {1,2,3,4};
        ArrayList<Integer> tutto = new ArrayList<>();
        for(int dice: aCase){
            tutto.add(dice);
        }
        assertEquals(0, straight.calScores(tutto));
    }

    @Test
    void testDrawAnotherCard(){
        assertFalse(straight.ableToDrawAnotherCard());
    }

}