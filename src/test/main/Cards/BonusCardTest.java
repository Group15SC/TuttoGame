package main.Cards;

import main.Logics.Dices;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class BonusCardTest {

    BonusCard bonus = new BonusCard(200);

    @Test
    void getCardType200() {
        assertEquals(CardType.BONUS, bonus.getCardType());
    }

    @Test
    void getPoints200() {
        assertEquals(200, bonus.getPoints());
    }

    @Test
    void testATutto(){
        ArrayList<Integer> aTuttoPair = new ArrayList<>();
        for(int i=0; i<3; i++){
            aTuttoPair.add(1);
            aTuttoPair.add(2);
        }
        assertEquals(1400, bonus.calScores(aTuttoPair)); // 1000+200+200=1400
    }

    @Test
    void testNotTutto(){
        ArrayList<Integer> aPairOfDice = new ArrayList<>();
        for(int i=0; i<3; i++){
            aPairOfDice.add(1);
        }
        aPairOfDice.add(5);
        assertEquals(1050, bonus.calScores(aPairOfDice)); // 1000+200+200=1400
    }

    @Test
    void testTuttoDefault(){
        assertFalse(bonus.ableToDrawAnotherCard());
    }

    @Test
    void testATurn(){
        // end the turn after first roll
        String stopOption = "E";
        InputStream Original = System.in; // backup System.in to restore it later
        System.setIn(new ByteArrayInputStream(stopOption.getBytes()));
        ArrayList<Integer> resultDices = bonus.handleTurn();
        System.setIn(Original);

        // expected to keep all valid dice after a roll
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



}