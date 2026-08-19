package test.blackJack;

import blackJack.BlackjackGame;
import blackJack.BlackjackRule;
import framework.cards.Deck;
import framework.factory.DeckFactory;
import framework.player.Player;
import framework.strategy.DealStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlackjackGameTest {

    @Test
    void shouldCreateGameWithPlayersAndRule() {
        Player player = new Player("Alice");
        BlackjackRule rule = new BlackjackRule();

        BlackjackGame game = new BlackjackGame(
                Arrays.asList(player),
                rule,
                new TestDeckFactory(),
                new TestDealStrategy()
        );

        assertEquals(1, game.getPlayers().size());
        assertSame(player, game.getPlayers().get(0));
        assertSame(rule, game.getRule());
    }

    @Test
    void shouldReturnProvidedPlayers() {
        List<Player> players = Arrays.asList(
                new Player("Alice"),
                new Player("Bob")
        );

        BlackjackGame game = new BlackjackGame(
                players,
                new BlackjackRule(),
                new TestDeckFactory(),
                new TestDealStrategy()
        );

        assertSame(players, game.getPlayers());
    }

    private static class TestDeckFactory implements DeckFactory {

        @Override
        public Deck createDeck() {
            return new Deck(new ArrayList<>());
        }
    }

    private static class TestDealStrategy implements DealStrategy {

        @Override
        public void deal(Deck deck, List<Player> players) {
        }
    }
}