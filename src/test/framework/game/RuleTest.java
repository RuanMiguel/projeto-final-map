package test.framework.game;

import framework.player.Player;
import framework.game.Game;
import framework.game.Rule;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RuleTest {

    @Test
    void shouldReturnTrueWhenGameIsFinished() {
        Rule rule = new TestRule();

        Game game = new TestGame();

        assertTrue(rule.gameFinished(game));
    }

    @Test
    void shouldReturnNullWhenThereIsNoWinner() {
        Rule rule = new TestRule();

        Game game = new TestGame();

        assertNull(rule.checkWinner(game));
    }

    private static class TestRule extends Rule {
    }

    private static class TestGame extends Game {

        public TestGame() {
            super(
                    new ArrayList<>(),
                    new TestRule(),
                    new TestDeckFactory(),
                    new TestDealStrategy()
            );
        }

        @Override
        protected void rounds() {
        }

        @Override
        protected void finish() {
        }
    }

    private static class TestDeckFactory implements framework.factory.DeckFactory {

        @Override
        public framework.cards.Deck createDeck() {
            return new framework.cards.Deck(new ArrayList<>());
        }
    }

    private static class TestDealStrategy
            implements framework.strategy.DealStrategy {

        @Override
        public void deal(
                framework.cards.Deck deck,
                java.util.List<Player> players
        ) {
        }
    }
}