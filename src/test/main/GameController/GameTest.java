package main.GameController;

import main.Cards.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    // test private method DrawACard
    @Test
    void TestDrawCard() throws Exception{
        ArrayList<Card> aDeck = new ArrayList<>();
        aDeck.add(new BonusCard(200));
        aDeck.add(new CloverleafCard());
        aDeck.add(new FireworksCard());

        Method method = Game.class.getDeclaredMethod("DrawACard", ArrayList.class);
        method.setAccessible(true);
        Card ResultCard = (Card) method.invoke(null, aDeck);
        assertEquals(CardType.FIREWORKS, ResultCard.GetCardType());
    }

    @Test
    void TestLengthOfDeckAfterDrawACard() throws Exception{
        ArrayList<Card> aDeck = new ArrayList<>();
        aDeck.add(new BonusCard(200));

        Method method = Game.class.getDeclaredMethod("DrawACard", ArrayList.class);
        method.setAccessible(true);
        Card ResultCard = (Card) method.invoke(null, aDeck);
        assertEquals(0, aDeck.size());
    }

    // test private method GetHighestPlayer
    @Test
    void TestHighestPlayerWithoutTie() throws Exception{
        ArrayList<Player> players = new ArrayList<>();
        Player player1 = new Player("A", 300);
        Player player2 = new Player("B", 200);
        players.add(player1);
        players.add(player2);

        ArrayList<Player> ExpectedHighest = new ArrayList<>();
        ExpectedHighest.add(player1);

        Method method = Game.class.getDeclaredMethod("GetHighestPlayer", ArrayList.class);
        method.setAccessible(true);
        ArrayList<Player> HighestPlayer = (ArrayList<Player>) method.invoke(null, players);
        assertEquals(ExpectedHighest, HighestPlayer);
    }

    @Test
    void TestHighestPlayerWithTie() throws Exception{
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

        Method method = Game.class.getDeclaredMethod("GetHighestPlayer", ArrayList.class);
        method.setAccessible(true);
        ArrayList<Player> HighestPlayer = (ArrayList<Player>) method.invoke(null, players);
        assertEquals(ExpectedHighest, HighestPlayer);
    }


    @Test
    void gameOn() {

    }


    @Test
    void TestGenerateACompleteCardSet() { // test if generate the right amount of cards
        var CardSet = Game.GenerateCardSet();
        assertEquals(56, CardSet.size());
    }

    @Test
    void TestAllTypesAreInclude() { // test if all types all included in the generated card set
        var CardSet = Game.GenerateCardSet();
        var CompleteType = new ArrayList<>(Arrays.asList(CardType.values())); // get all types in Card Types
        var types = new ArrayList<>();
        for (Card card: CardSet) {
            types.add(card.GetCardType()); // get all card types in generated card set
        }
        assertTrue(types.containsAll(CompleteType));
    }


}