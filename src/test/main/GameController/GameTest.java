package main.GameController;

import main.Cards.Card;
import main.Cards.CardType;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicTreeUI;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
//
//    private Card DrawACard(ArrayList<Card> CardSet) {
//        try {
//            Method method = Game.class.getDeclaredMethod("DrawACard");
//            method.setAccessible(true);
//            return (Card) method.invoke(Game);
//        } catch (ReflectiveOperationException exception) {
//            fail();
//            return ArrayList.empty();
//        }
//    }
//    private Optional<Card> getPreviousCard(Card pCard) {
//        try {
//            Method method = FoundationPile.class.
//                    getDeclaredMethod("getPreviousCard", Card.class);
//            ((Method) method).setAccessible(true);
//            return (Optional<Card>) method.invoke(aPile, pCard);
//        } catch( ReflectiveOperationException exception ) {
//            fail();
//            return Optional.empty();
//        }
//    }


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