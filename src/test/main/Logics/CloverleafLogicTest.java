package main.Logics;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CloverleafLogicTest {

    @Test
    void test2Tutto() {
        CloverleafLogic cloverleaf = new CloverleafLogic(new RollDice() {
            int[] aCase = {1,1,1,2,2,2,3,3,3,4,4,4};
            int i = 0;
            @Override
            public int rollDice() {
               int dice = aCase[i];
               i ++;
               return dice;
            }
        });
        cloverleaf.getValidDices();
        ArrayList<Integer> actual = cloverleaf.getKeptDices();
        ArrayList<Integer> expected = new ArrayList<>();
        for(int i = 1; i<=4; i++){
            expected.add(i);
            expected.add(i);
            expected.add(i);
        }
        assertEquals(expected, actual);
    }

    @Test
    void testNull() {
        CloverleafLogic cloverleaf = new CloverleafLogic(new RollDice() {
            int[] aCase = {2,2,3,3,4,4};
            int i = 0;
            @Override
            public int rollDice() {
                int dice = aCase[i];
                i ++;
                return dice;
            }
        });
        cloverleaf.getValidDices();
        assertFalse(cloverleaf.isTutto());
    }

    @Test
    void getKeptDices3() {
        CloverleafLogic newCloverleaf = new CloverleafLogic(new RollDice() {
            int[] aCase= {1,1,1,2,2,2,1,1,2,2,2,3,1};
            int i = 0;
            @Override
            public int rollDice() {
                int dice = aCase[i];
                i ++;
                return dice;
            }
        });

        String stopOption = "1,1,2,2,2";
        InputStream Original = System.in; // backup System.in to restore it later
        System.setIn(new ByteArrayInputStream(stopOption.getBytes()));
        newCloverleaf.getValidDices();
        ArrayList<Integer> actual = newCloverleaf.getKeptDices();

        int[] expected = {1,1,1,2,2,2,1,1,2,2,2,1};
        ArrayList<Integer> keptDices = new ArrayList<>();
        for(int dice: expected){
            keptDices.add(dice);
        }
    }


    @Test
    void isTutto() {
    }

    @Test
    void getValidDices() {
    }
}