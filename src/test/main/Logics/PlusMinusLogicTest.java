package main.Logics;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlusMinusLogicTest {

    PlusMinusLogic plusMinus = new PlusMinusLogic(new RollDice() {
        int[] aCase = {1,1,1,2,2,2}; //
        int i = 0;
        @Override
        public int rollDice() {
            int dice = aCase[i];
            i ++;
            return dice;
        }
    });


    @Test
    void testIsTutto() {
        plusMinus.getValidDices();
        assertTrue(plusMinus.isTutto());
    }

    @Test
    void testKeptDices() {
        plusMinus.getValidDices();
        ArrayList<Integer> actualDices = plusMinus.getKeptDices();
        ArrayList<Integer> expectedDices = new ArrayList<>();
        for(int i=0; i<3; i++){
            expectedDices.add(1);
        }
        for(int i=0; i<3; i++){
            expectedDices.add(2);
        }
        assertEquals(expectedDices, actualDices);
    }


    @Test
    void testNotTutto() {
        PlusMinusLogic newPlusMinus = new PlusMinusLogic(new RollDice() {
            int[] aCase = {2,2,3,3,4,4}; // 2, 2, 3, 3, 4, 4
            int i = 0;
            @Override
            public int rollDice() {
                int dice = aCase[i];
                i ++;
                return dice;
            }
        });

        newPlusMinus.getValidDices();
        ArrayList<Integer> actualDices = newPlusMinus.getKeptDices();
        ArrayList<Integer> expectedDices = new ArrayList<>();
        assertEquals(expectedDices, actualDices);
    }

    @Test
    void testHandleNotTutto(){
        int[] aCase = {1,1,2,2,3,3};
        ArrayList<Integer> anotherCase = new ArrayList<>();
        for(int i: aCase){
            anotherCase.add(i);
        }

        plusMinus.setKeptDices(new ArrayList<Integer>());
        plusMinus.setaPairOfDices(anotherCase);

        assertEquals(4, plusMinus.handelNotTutto(6, true));
        // should keep 1,1 and result 4 as the next roll
    }

}