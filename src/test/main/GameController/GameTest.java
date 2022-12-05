package main.GameController;

import main.Cards.*;
import main.Logics.Dices;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    // test private method DrawACard
    @Test
    void testDrawCard() throws Exception{
        ArrayList<Card> aDeck = new ArrayList<>();
        aDeck.add(new BonusCard(200));
        aDeck.add(new CloverleafCard());
        aDeck.add(new FireworksCard());

        Method method = Game.class.getDeclaredMethod("drawACard", ArrayList.class);
        method.setAccessible(true);
        Card ResultCard = (Card) method.invoke(null, aDeck);
        assertEquals(CardType.FIREWORKS, ResultCard.getCardType());
    }

    @Test
    void testLengthOfDeckAfterDrawACard() throws Exception{
        ArrayList<Card> aDeck = new ArrayList<>();
        aDeck.add(new BonusCard(200));

        Method method = Game.class.getDeclaredMethod("drawACard", ArrayList.class);
        method.setAccessible(true);
        Card ResultCard = (Card) method.invoke(null, aDeck);
        assertEquals(0, aDeck.size());
    }

    @Test
    void testEmptyDeckRedraw() throws Exception{
        ArrayList<Card> emptyDeck = new ArrayList<>();

        Method method = Game.class.getDeclaredMethod("drawACard", ArrayList.class);
        method.setAccessible(true);
        Card resultCard = (Card) method.invoke(null, emptyDeck);
        assertTrue(resultCard instanceof Card);
    }

    // test private method GetHighestPlayer
    @Test
    void testHighestPlayerWithoutTie() throws Exception{
        ArrayList<Player> players = new ArrayList<>();
        Player player1 = new Player("A", 300);
        Player player2 = new Player("B", 200);
        players.add(player1);
        players.add(player2);

        ArrayList<Player> ExpectedHighest = new ArrayList<>();
        ExpectedHighest.add(player1);

        Method method = Game.class.getDeclaredMethod("getHighestPlayer", ArrayList.class);
        method.setAccessible(true);
        ArrayList<Player> HighestPlayer = (ArrayList<Player>) method.invoke(null, players);
        assertEquals(ExpectedHighest, HighestPlayer);
    }

    @Test
    void testHighestPlayerWithTie() throws Exception{
        ArrayList<Player> players = new ArrayList<>();
        Player player1 = new Player("A", 300);
        Player player2 = new Player("B", 200);
        Player player3 = new Player("C", 300);
        players.add(player1);
        players.add(player2);
        players.add(player3);

        ArrayList<Player> ExpectedHighest = new ArrayList<>();
        ExpectedHighest.add(player1);
        ExpectedHighest.add(player3);

        Method method = Game.class.getDeclaredMethod("getHighestPlayer", ArrayList.class);
        method.setAccessible(true);
        ArrayList<Player> HighestPlayer = (ArrayList<Player>) method.invoke(null, players);
        assertEquals(ExpectedHighest, HighestPlayer);
    }

    @Test
    void testGenerateACompleteCardSet() { // test if generate the right amount of cards
        ArrayList<Card> CardSet = Game.generateCardSet();
        assertEquals(56, CardSet.size());
    }

    @Test
    void testAllTypesAreInclude() { // test if all types all included in the generated card set
        var CardSet = Game.generateCardSet();
        var CompleteType = new ArrayList<>(Arrays.asList(CardType.values())); // get all types in Card Types
        var types = new ArrayList<>();
        for (Card card: CardSet) {
            types.add(card.getCardType()); // get all card types in generated card set
        }
        assertTrue(types.containsAll(CompleteType));
    }

    @Test
    void testDisplayOption(){
        Player player1 = new Player("A",300);

        String stopOption = "R";
        InputStream Original = System.in; // backup System.in to restore it later
        System.setIn(new ByteArrayInputStream(stopOption.getBytes()));
        String option = Game.askForContinueOption(player1, "D");
        System.setIn(Original);

        assertEquals("R", option);

    }

    @Test
    void testEndOption(){
        Player player1 = new Player("A",300);

        String stopOption = "R";
        InputStream Original = System.in; // backup System.in to restore it later
        System.setIn(new ByteArrayInputStream(stopOption.getBytes()));
        String option = Game.askForContinueOption(player1, "E");
        System.setIn(Original);

        assertEquals("R", option);
    }

    @Test
    void testInvalidOption(){
        Player player1 = new Player("A",300);

        String stopOption = "R";
        InputStream Original = System.in; // backup System.in to restore it later
        System.setIn(new ByteArrayInputStream(stopOption.getBytes()));
        String option = Game.askForContinueOption(player1, "M");
        System.setIn(Original);

        assertEquals("R", option);
    }

    @Test
    void testDrawAStopCard(){
        Game game = new Game();

        ArrayList<Card> aDeck = new ArrayList<>();
        aDeck.add(new FireworksCard());
        aDeck.add(new StopCard());

        Player player2 = new Player("B", 0);
        Card card = new StopCard();
        int scoreThisTurn = 0;
        String option = "R";
        // test case: a player got a stop card, with 0 points in this turn, get 0 point in the end.

        String expected = "The score you obtained in this turn is: 0";

        final PrintStream standardOut = System.out; //restoring it to its original state when our test terminates
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        game.handleAPlayersTurn(aDeck,player2,card,scoreThisTurn,option);
        assertEquals(expected, outputStreamCaptor.toString().trim());
        // put the original out back
        System.setOut(standardOut);
    }


}