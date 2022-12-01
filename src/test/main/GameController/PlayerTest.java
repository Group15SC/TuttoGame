package main.GameController;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;

    @BeforeEach
    void aPlayer() {
        Player player = new Player("Bob", 0);
        this.player = player;
    }

    @Test
     void getName() {
        assertEquals("Bob", player.getName());
    }

    @Test
    void getScore() {
        assertEquals(0, player.getScore());
    }

    @Test
    void setScore() {
        player.setScore(100);
        assertEquals(100, player.getScore());
    }
}