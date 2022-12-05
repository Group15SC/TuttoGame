package main.Cards;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class FireworksCardTest {

    FireworksCard fireworks = new FireworksCard();

    @Test
    void testGetCardType() {
        assertEquals(CardType.FIREWORKS, fireworks.getCardType());
    }

    @Test
    void testCalScores(){
        ArrayList<Integer> aCase = new ArrayList<>();
        aCase.add(1);
        aCase.add(2);
        aCase.add(5);
        aCase.add(2);
        aCase.add(2);
        assertEquals(350, fireworks.calScores(aCase));
    }

    @Test
    void testHandleTurn(){

        ArrayList<Integer> resultDices = fireworks.handleTurn();

        boolean ifPass = false;
        for(int dice:resultDices){
            int occurrences = Collections.frequency(resultDices, dice);
            if (dice != 1 && dice != 5 && occurrences != 3) {
                ifPass = false;
            } else {
                ifPass = true;
            }
        }
        if(resultDices.isEmpty()){ // if rolled a null, nothing kept in this turn
            ifPass = true;
        }
        assertTrue(ifPass);
    }

    @Test
    void testDefault(){
        assertFalse(fireworks.ableToDrawAnotherCard());
    }

}