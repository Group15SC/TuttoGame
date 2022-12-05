package main.Logics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class FireworksLogicTest {

    FireworksLogic fireworks = new FireworksLogic(new Dices());

   @Test
    void testATurn(){
       fireworks.getValidDices();
       ArrayList<Integer> resultDices = fireworks.getKeptDices();
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