package main.Logics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FireworksLogicTest {

    FireworksLogic fireworks = new FireworksLogic();

    @Test
    void TestIfGetAPairOfDices() {
        assertEquals(ArrayList.class, fireworks.GetValidDices().getClass());
    }

    @Test
    void TestIfAllDicesAreBetweenOneAndSix(){
        for(int Dice: fireworks.GetValidDices()){
            assertTrue(Dice>0 && Dice<7);
        }
    }

}