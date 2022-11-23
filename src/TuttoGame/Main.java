package TuttoGame;

import TuttoGame.GameController.Player;
import TuttoGame.Logic;
import TuttoGame.Logics.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Player player1 = new Player("A", 1000);
        BonusLogic fwlogic = new BonusLogic();
        ArrayList<Integer> result = fwlogic.GetValidDices(player1);
        for(int r: result){
            System.out.println(r);
        }
    }
}

