package main.Logics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BonusLogicTest {

    ArrayList<Integer> aCase;
    int diceIndex = 0;

    public BonusLogicTest(ArrayList<Integer> aCase, int diceIndex) {
        this.aCase = aCase;
        this.diceIndex = diceIndex;
    }

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
            diceIndex++;
            return aCase.get(diceIndex);
        }


    @Test
    void isTutto() {
    }

    @Test
    void getKeptDices() {
    }

    @Test
    void getValidDices() {
    }
}