package main.Logics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DicesTest {

    @Test
    void TestDiceLengthSixDices() {
        assertEquals(6, Dices.RollDices(6).size());
    }

    @Test
    void TestDicesValueWithinOneAndSeven(){
        ArrayList<Integer> DiceSet = Dices.RollDices(12);
        for(int dice: DiceSet){
            assertFalse(dice<1 || dice>6);
        } // check if the dice include value greater than 6 or less than 1
    }

    @Test
    void displayDices() {
        // set up
        final PrintStream standardOut = System.out; //restoring it to its original state when our test terminates
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        ArrayList<Integer> dices = new ArrayList<>();
        dices.add(1);
        dices.add(2);
        dices.add(3);
        Dices.DisplayDices(dices);
        String expected = "The result of this roll is:\n1 2 3";
        assertEquals(expected, outputStreamCaptor.toString().trim());
        // put the original out back
        System.setOut(standardOut);
    }

    @Test
    void TestCalDiceScoreWithSingleValidDice() {
        ArrayList<Integer> dices = new ArrayList<>();
        for(int i=1; i<=6; i++){
            dices.add(i);
        } // 1,2,3,4,5,6 -- 50+100=150
        assertEquals(150, Dices.CalDiceScores(dices));
    }

    @Test
    void TestCalDiceScoreWithTriplet() {
        ArrayList<Integer> dices = new ArrayList<>();
        for(int i=1; i<=3; i++){
            dices.add(2);
        }
        dices.add(4);
        dices.add(5);
        dices.add(6); // 2,2,2,4,5,6 -- 50+200=250
        assertEquals(250, Dices.CalDiceScores(dices));
    }

    @Test
    void TestCalDiceScoreWithTripletOne() {
        ArrayList<Integer> dices = new ArrayList<>();
        for(int i=1; i<=3; i++){
            dices.add(1);
        }
        dices.add(4);
        dices.add(5);
        dices.add(6); // 1,1,1,4,5,6 -- 1000+50=1050
        assertEquals(1050, Dices.CalDiceScores(dices));
    }

    @Test
    void TestCalDiceScoreWithTripletFive() {
        ArrayList<Integer> dices = new ArrayList<>();
        for(int i=1; i<=3; i++){
            dices.add(5);
        }
        dices.add(4);
        dices.add(1);
        dices.add(6); // 5,5,5,4,1,6 -- 500+10=600
        assertEquals(600, Dices.CalDiceScores(dices));
    }

    @Test
    void TestInputValidKeepDice() {
        String InputDiceToKeep = "1,5";
        ArrayList<Integer> Expected = new ArrayList<>();
        Expected.add(1);
        Expected.add(5);
        InputStream Original = System.in; // backup System.in to restore it later
        System.setIn(new ByteArrayInputStream(InputDiceToKeep.getBytes()));
        assertEquals(Expected, Dices.GetKeepDices());
        System.setIn(Original);
    }

    @Test
    void testExpectedException() {
        //don't know how to deal with
    }
}