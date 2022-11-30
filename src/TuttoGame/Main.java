package TuttoGame;

import TuttoGame.Cards.Card;
import TuttoGame.GameController.Game;
import TuttoGame.Logics.Dices;
import TuttoGame.Logics.MultiplyTwoLogic;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Game game = new Game();
//        game.GameOn();


//        Player player1 = new Player("A", 1000);
        Logic fwlogic = new MultiplyTwoLogic();
////        MultiplyTwoLogic test = new MultiplyTwoLogic();
////
        ArrayList<Integer> result = fwlogic.GetValidDices();
        for(int r: result){
            System.out.println(r);
        }
//        ArrayList<Card> test = Game.GenerateCardSet();
//        System.out.println(test.size());
//        for(Card card: test) {
//            System.out.println(card.GetCardType());
//        }

    }
}

