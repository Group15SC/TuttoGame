package main.GameController;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UITest {

    @Test
    void turnStartingOption() {

        String stopOption = "E";
        InputStream Original = System.in; // backup System.in to restore it later
        System.setIn(new ByteArrayInputStream(stopOption.getBytes()));
        String stop = UI.turnStartingOption();
        System.setIn(Original);

        assertEquals("E", stop);
    }

    @Test
    void tuttoOption() {
        String stopOption = "E";
        InputStream Original = System.in; // backup System.in to restore it later
        System.setIn(new ByteArrayInputStream(stopOption.getBytes()));
        String stop = UI.tuttoOption();
        System.setIn(Original);

        assertEquals("E", stop);
    }

    @Test
    void halfwayOption() {
        String invalidOpt = "E";
        InputStream Original = System.in; // backup System.in to restore it later
        System.setIn(new ByteArrayInputStream(invalidOpt.getBytes()));
        String stop = UI.halfwayOption();
        assertEquals("E", stop);
        System.setIn(Original);
    }
}