package main.Logics;

import main.GameController.Game;
import main.GameController.Player;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class StraightLogicTest {

    StraightLogic straight = new StraightLogic(new Dices());

    public static ArrayList<Integer> constructACase(ArrayList<Integer> aCase, int a, int b, int c, int d, int e, int f){
        aCase.add(a);
        aCase.add(b);
        aCase.add(c);
        aCase.add(d);
        aCase.add(e);
        aCase.add(f);
        return aCase;
    }

    @Test
    void testTuttoForStraight(){
        ArrayList<Integer> aCase = new ArrayList<>();
        constructACase(aCase, 1,2,3,4,5,6);
        assertTrue(straight.isTuttoForStraight(aCase, new ArrayList<>()));
    }

    @Test
    void testValidForStraight1(){
        ArrayList<Integer> aCase = new ArrayList<>();
        constructACase(aCase, 1,2,3,4,5,6);
        assertTrue(straight.isValidForStraight(aCase, new ArrayList<>()));
    }

    @Test
    void testValidForStraight2(){
        ArrayList<Integer> rolledDices = new ArrayList<>();
        ArrayList<Integer> keptDices = new ArrayList<>();
        for(int i=1; i<=3; i++){
            rolledDices.add(i); //1,2,3
            keptDices.add(i+3); //4,5,6
        }
        assertTrue(straight.isValidForStraight(rolledDices, keptDices));
    }

    @Test
    void notValidForStraight(){
        ArrayList<Integer> rolledDices = new ArrayList<>();
        ArrayList<Integer> keptDices = new ArrayList<>();
        for(int i=1; i<=3; i++){
            rolledDices.add(i); //1,2,3
            keptDices.add(i); //1,2,3
        assertFalse(straight.isValidForStraight(rolledDices, keptDices));
        }
    }

    @Test
    void validDicesInThisRoll(){
        ArrayList<Integer> rolledDices = new ArrayList<>();
        ArrayList<Integer> keptDices = new ArrayList<>();
        for(int i=1; i<=3; i++){
            rolledDices.add(i); //1,2,3
            keptDices.add(i+3); //4,5,6
        }
        ArrayList<Integer> expected = rolledDices; // keep 1,2,3
        ArrayList<Integer> actual = StraightLogic.validInThisRollForStraight(rolledDices, keptDices);
        assertEquals(expected, actual);
    }

    @Test
    void testValidKeep(){
        ArrayList<Integer> rolledDices = new ArrayList<>();
        ArrayList<Integer> keptDices = new ArrayList<>();
        ArrayList<Integer> dicesToKeep = new ArrayList<>();
        for(int i=1; i<=3; i++){
            rolledDices.add(i); //1,2,3
            keptDices.add(i+2); //3,4,5
        }
        dicesToKeep.add(1);
        dicesToKeep.add(2);
        assertTrue(StraightLogic.isValidKeepForStraight(dicesToKeep, rolledDices, keptDices));
    }

    @Test
    void testInvalidKeep(){
        ArrayList<Integer> rolledDices = new ArrayList<>();
        ArrayList<Integer> keptDices = new ArrayList<>();
        for(int i=1; i<=3; i++){
            rolledDices.add(i); //1,2,3
            keptDices.add(i+2); //3,4,5
        }
        ArrayList<Integer> dicesToKeep = rolledDices; // try to keep 1,2,3 should fail
        assertFalse(StraightLogic.isValidKeepForStraight(dicesToKeep, rolledDices, keptDices));
    }


    @Test
    void getKeptDices() {
        StraightLogic newStraight = new StraightLogic(new RollDice() {
            int[] aCase= {1,2,3,4,5,6};
            int i = 0;
            @Override
            public int rollDice() {
                int dice = aCase[i];
                i ++;
                return dice;
            }
        });
        newStraight.getValidDices();
        assertTrue(newStraight.isTutto());
    }

    @Test
    void testDefaultIsTutto() {
        assertFalse(straight.isTutto());
    }

    @Test
    void getValidDices() {
    }
}