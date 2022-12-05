//package main.GameController;
//
//import org.junit.jupiter.api.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class GameInitializationTest {
//
//    //GameInitialization game = new GameInitialization();
//
//    @Test
//    void askForNumberOfPlayers() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//
//        Method method = GameInitialization.class.getDeclaredMethod("askForNumberOfPlayers", int.class);
//        method.setAccessible(true);
//        //ArrayList<Player> HighestPlayer = (ArrayList<Player>) method.invoke(null, players);
//
//
//        InputStream Original = System.in;
//        System.setIn(new ByteArrayInputStream("2\n".getBytes()));
//        int num = (int) method.invoke(null, null);
//        //int num = GameInitialization.askForNumberOfPlayers();
//        System.out.println(num);
//        System.setIn(Original);
//        assertEquals(2, num);
//    }
//
//
//    @Test
//    void getNumberOfPlayers() {
//    }
//
//    @Test
//    void getWinningPoints() {
//    }
//
//    @Test
//    void getPlayers() {
//    }
//}