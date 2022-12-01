package main.Logics;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest {

    private ArrayList<Integer> aDiceSet;
//    private ArrayList<Integer> aDiceSet;

    @BeforeEach
    void CreateDices(){
        //initialize an empty dice set
        this.aDiceSet = new ArrayList<>();
    }


    @Test
    void TestSingleValid() {
        for(int i=1; i<=6; i++){
            aDiceSet.add(i);
        } // 1,2,3,4,5,6 -- should be valid
        assertTrue(Logic.IsValid(aDiceSet));
    }

    @Test
    void TestTripletOne() {
        for (int i=0; i<3; i++){
            aDiceSet.add(1);
        }
        aDiceSet.add(2);
        aDiceSet.add(3); // 1,1,1,2,3 -- should be valid
        assertTrue(Logic.IsValid(aDiceSet));
    }

    @Test
    void TestTripletThree() {
        for (int i=0; i<3; i++){
            aDiceSet.add(3);
        }
        aDiceSet.add(2);
        aDiceSet.add(3); // 3,3,3,2,3 -- should be valid
        assertTrue(Logic.IsValid(aDiceSet));
    }

    @Test
    void TestInvalidDice() {
        aDiceSet.add(2);
        aDiceSet.add(2);
        aDiceSet.add(3); // 2,2,3 -- should be invalid
        assertFalse(Logic.IsValid(aDiceSet));
    }

    @Test
    void TestKeepSingleValidDice() {
        aDiceSet.add(1);
        aDiceSet.add(1);
        aDiceSet.add(5); // 1,1,5 all valid single dice - can be kept
        assertTrue(Logic.IsValidKeep(aDiceSet));
    }

    @Test
    void TestKeepTriplet() {
        for(int i=0; i<3; i++) {
            aDiceSet.add(6);
        } // 6,6,6 -- triplet can be kept
        assertTrue(Logic.IsValidKeep(aDiceSet));
    }

    @Test
    void TestKeepMoreThanThree() {
        for(int i=0; i<4; i++) {
            aDiceSet.add(6);
        } // 6,6,6,6 -- triplet + invalid dice -- cannot be kept
        assertFalse(Logic.IsValidKeep(aDiceSet));
    }

    @Test
    void TestKeepInvalidDice() {
        aDiceSet.add(1);
        aDiceSet.add(2);
        aDiceSet.add(2); // 1,2,2 include invalid dice, cannot be kept
        assertFalse(Logic.IsValidKeep(aDiceSet));
    }

    @Test
    void TestFilterSingleValidDice() {
        for(int i = 1; i<=6; i++) {
            aDiceSet.add(i); // 1,2,3,4,5,6 -- keep 1&5
        }
        ArrayList<Integer> KeptDices = new ArrayList<>();
        KeptDices.add(1);
        KeptDices.add(5);
        assertEquals(Logic.ValidInThisRoll(aDiceSet), KeptDices);
    }

    @Test
    void TestFilterTriplet() {
        for(int i = 1; i<=3; i++) {
            aDiceSet.add(1);
        }
        aDiceSet.add(2);
        aDiceSet.add(5); // 1,1,1,2,5 -- keep 1,1,1&5
        ArrayList<Integer> KeptDices = new ArrayList<>();
        for(int i = 1; i<=3; i++) {
            KeptDices.add(1);
        }
        KeptDices.add(5);
        assertEquals(Logic.ValidInThisRoll(aDiceSet), KeptDices);
    }

    @Test
    void TestInputE() {
        String end = "E";
        InputStream Original = System.in; // backup System.in to restore it later
        System.setIn(new ByteArrayInputStream(end.getBytes()));
        assertEquals("E", Logic.HalfwayOption());
        System.setIn(Original);
    }

    @Test
    void TestInputR() {
        String cont = "R";
        InputStream Original = System.in; // backup System.in to restore it later
        System.setIn(new ByteArrayInputStream(cont.getBytes()));
        assertEquals("R", Logic.HalfwayOption());
        System.setIn(Original);
    }

//    @Test
//    void TestInvalid() {
//        String InvalidInput = "M";
//        InputStream Original = System.in; // backup System.in to restore it later
//        System.setIn(new ByteArrayInputStream(InvalidInput.getBytes()));
//        assertNotEquals("E", Logic.HalfwayOption());
//        System.setIn(Original);
//    }

}