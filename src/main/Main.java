package main;

import main.Cards.BonusCard;
import main.Cards.Card;
import main.GameController.Game;
import main.GameController.Player;
import main.Logics.CloverleafLogic;
import main.Logics.Logic;
import main.Logics.RollDice;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.gameOn();
    }
}

