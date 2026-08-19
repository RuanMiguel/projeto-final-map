package test.framework.game;

import framework.game.Game;
import framework.game.Rule;
import framework.cards.Deck;
import framework.factory.DeckFactory;
import framework.player.Player;
import framework.strategy.DealStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void shouldCreateGameWithProvidedDependencies() {
        List<Player> players = Arrays.asList(
                new Player("Alice"),
                new Player("Bob")
        );

        Rule rule = new TestRule();
        DeckFactory deckFactory = new TestDeckFactory();
        DealStrategy dealStrategy = new TestDealStrategy();

        Game game = new TestGame(players, rule, deckFactory, dealStrategy);

        assertEquals(players, game.getPlayers());
        assertEquals(rule, game.getRule());
    }

    @Test
    void shouldCreateDeckWhenGameStarts() {
        List<Player> players = Arrays.asList(
                new Player("Alice"),
                new Player("Bob")
        );

        TestDeckFactory deckFactory = new TestDeckFactory();

        Game game = new TestGame(
                players,
                new TestRule(),
                deckFactory,
                new TestDealStrategy()
        );

        game.start();

        assertTrue(deckFactory.deckCreated);
    }

    @Test
    void shouldExecuteGameLifecycleWhenGameStarts() {
        List<Player> players = Arrays.asList(
                new Player("Alice"),
                new Player("Bob")
        );

        TestGame game = new TestGame(
                players,
                new TestRule(),
                new TestDeckFactory(),
                new TestDealStrategy()
        );

        game.start();

        assertTrue(game.roundsExecuted);
        assertTrue(game.finishExecuted);
    }

    @Test
    void shouldReturnPlayers() {
        List<Player> players = Arrays.asList(
                new Player("Alice"),
                new Player("Bob")
        );

        Game game = new TestGame(
                players,
                new TestRule(),
                new TestDeckFactory(),
                new TestDealStrategy()
        );

        assertSame(players, game.getPlayers());
    }

    @Test
    void shouldReturnRule() {
        Rule rule = new TestRule();

        Game game = new TestGame(
                new ArrayList<>(),
                rule,
                new TestDeckFactory(),
                new TestDealStrategy()
        );

        assertSame(rule, game.getRule());
    }

    // Classe concreta apenas para permitir o teste da classe abstrata Game
    private static class TestGame extends Game {

        boolean roundsExecuted = false;
        boolean finishExecuted = false;

        public TestGame(
                List<Player> players,
                Rule rule,
                DeckFactory deckFactory,
                DealStrategy dealStrategy
        ) {
            super(players, rule, deckFactory, dealStrategy);
        }

        @Override
        protected void rounds() {
            roundsExecuted = true;
        }

        @Override
        protected void finish() {
            finishExecuted = true;
        }
    }

    private static class TestRule extends Rule {
    }

    private static class TestDeckFactory implements DeckFactory {

        boolean deckCreated = false;

        @Override
        public Deck createDeck() {
            deckCreated = true;
            return new Deck(new ArrayList<>());
        }
    }

    private static class TestDealStrategy implements DealStrategy {

        boolean dealExecuted = false;

        @Override
        public void deal(Deck deck, List<Player> players) {
            dealExecuted = true;
        }
    }
}