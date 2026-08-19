package test.framework.player;

import framework.cards.Hand;
import framework.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void shouldCreatePlayerWithName() {
        Player player = new Player("Alice");

        assertEquals("Alice", player.getName());
    }

    @Test
    void shouldCreatePlayerWithEmptyHand() {
        Player player = new Player("Alice");

        assertNotNull(player.getHand());
        assertTrue(player.getHand().getCards().isEmpty());
    }

    @Test
    void shouldReturnSameHandInstance() {
        Player player = new Player("Alice");

        Hand hand = player.getHand();

        assertSame(hand, player.getHand());
    }
}