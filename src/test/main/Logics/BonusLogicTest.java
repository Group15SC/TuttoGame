package main.Logics;

import main.GameController.Game;
import main.GameController.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BonusLogicTest {

//    ArrayList<Integer> aCase;
//    int diceIndex = 0;
//
//    public BonusLogicTest(ArrayList<Integer> aCase, int diceIndex) {
//        this.aCase = aCase;
//        this.diceIndex = diceIndex;
//    }

    public static ArrayList<Integer> constructACase(ArrayList<Integer> aCase, int a, int b, int c, int d, int e, int f){
        aCase.add(a);
        aCase.add(b);
        aCase.add(c);
        aCase.add(d);
        aCase.add(e);
        aCase.add(f);
        return aCase;
    }
    BonusLogic bonus = new BonusLogic(new RollDice() {
        @Override
        public int rollDice() {
//            diceIndex++;
//            return aCase.get(diceIndex);
            return 1;
        }
    });


    @Test
    void testDefaultIsTutto() {
        assertFalse(bonus.isTutto());
    }

    @Test
    void getKeptDices() {
        bonus.getValidDices();
        ArrayList<Integer> expectedDices= new ArrayList<>();
        for(int i=0; i<6; i++) {
            expectedDices.add(1);
        }
        assertEquals(expectedDices,bonus.getKeptDices());
    }

    @Test
    void getValidDices() {
    }

    @Test
    void testHandleNotTuttoEnd() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> aPairOfDices = new ArrayList<>();
        aPairOfDices = constructACase(aPairOfDices,1,2,3,4,5,6);
        bonus.setaPairOfDices(aPairOfDices);
        bonus.setKeptDices(new ArrayList<>());
        bonus.setContinueTurn(true);
//        bonus.setNotTutto(true);
        int actual = bonus.handleNotTutto(6, "E", true);
        assertEquals(6,actual);
    }

    @Test
    void testHandleNotTuttoContinue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> aPairOfDices = new ArrayList<>();
        aPairOfDices = constructACase(aPairOfDices,1,2,3,4,5,6);
        bonus.setaPairOfDices(aPairOfDices);
        bonus.setKeptDices(new ArrayList<>());
        bonus.setContinueTurn(true);
//        bonus.setNotTutto(true);

        String InputDiceToKeep = "1,5";
        InputStream Original = System.in; // backup System.in to restore it later
        System.setIn(new ByteArrayInputStream(InputDiceToKeep.getBytes()));
        int actual = bonus.handleNotTutto(6, "R", true);
        System.setIn(Original);

        assertEquals(4, actual);

    }

    @Test
    void testGetValidDices() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BonusLogic newBonus = new BonusLogic(new RollDice() {
            int i = 0;
            @Override
            public int rollDice() {
                i ++;
                return i; // get 1,2,3,4,5,6
            }
        });

        String halfwayEnd = "E";
        InputStream Original = System.in; // backup System.in to restore it later
        System.setIn(new ByteArrayInputStream(halfwayEnd.getBytes()));
        newBonus.getValidDices(); // end the turn, should get [1,5]

        ArrayList<Integer> expectedKeptDices = new ArrayList<>();
        expectedKeptDices.add(1);
        expectedKeptDices.add(5);
        assertEquals(expectedKeptDices, newBonus.getKeptDices());
        System.setIn(Original);
    }

    @Test
    void testRolledAnInvalidDice(){
        BonusLogic newBonus = new BonusLogic(new RollDice() {
            int[] aCase = {};
            int i  = 0;
            @Override
            public int rollDice() {
                int dice = aCase[i];
                i++;
                return dice;
            }
        });
    }

}