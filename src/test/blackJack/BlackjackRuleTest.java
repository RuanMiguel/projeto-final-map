package test.blackJack;

import blackJack.BlackjackRule;
import framework.cards.BasicCard;
import framework.factory.DeckFactory;
import framework.cards.Deck;
import framework.game.Game;
import framework.player.Player;
import framework.strategy.DealStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlackjackRuleTest {

    @Test
    void shouldCalculateNumberCardsCorrectly() {
        Player player = new Player("Alice");

        player.getHand().addCard(
                new BasicCard("Copas", "5")
        );

        player.getHand().addCard(
                new BasicCard("Ouros", "7")
        );

        BlackjackRule rule = new BlackjackRule();

        assertEquals(12, rule.calculateScore(player));
    }

    @Test
    void shouldCalculateFaceCardsAsTen() {
        Player player = new Player("Alice");

        player.getHand().addCard(
                new BasicCard("Copas", "K")
        );

        player.getHand().addCard(
                new BasicCard("Ouros", "Q")
        );

        BlackjackRule rule = new BlackjackRule();

        assertEquals(20, rule.calculateScore(player));
    }

    @Test
    void shouldCalculateAceAsElevenWhenPossible() {
        Player player = new Player("Alice");

        player.getHand().addCard(
                new BasicCard("Copas", "A")
        );

        player.getHand().addCard(
                new BasicCard("Ouros", "5")
        );

        BlackjackRule rule = new BlackjackRule();

        assertEquals(16, rule.calculateScore(player));
    }

    @Test
    void shouldConvertAceFromElevenToOneWhenScoreExceeds21() {
        Player player = new Player("Alice");

        player.getHand().addCard(
                new BasicCard("Copas", "A")
        );

        player.getHand().addCard(
                new BasicCard("Ouros", "9")
        );

        player.getHand().addCard(
                new BasicCard("Paus", "8")
        );

        BlackjackRule rule = new BlackjackRule();

        assertEquals(18, rule.calculateScore(player));
    }

    @Test
    void shouldCalculateBlackjack() {
        Player player = new Player("Alice");

        player.getHand().addCard(
                new BasicCard("Copas", "A")
        );

        player.getHand().addCard(
                new BasicCard("Ouros", "K")
        );

        BlackjackRule rule = new BlackjackRule();

        assertEquals(21, rule.calculateScore(player));
    }

    @Test
    void shouldReturnTrueWhenGameHasNoPlayers() {
        BlackjackRule rule = new BlackjackRule();

        Game game = createGame(new ArrayList<>());

        assertTrue(rule.gameFinished(game));
    }

    @Test
    void shouldReturnTrueWhenPlayerReaches21() {
        Player player = new Player("Alice");

        player.getHand().addCard(
                new BasicCard("Copas", "A")
        );

        player.getHand().addCard(
                new BasicCard("Ouros", "K")
        );

        BlackjackRule rule = new BlackjackRule();

        Game game = createGame(Arrays.asList(player));

        assertTrue(rule.gameFinished(game));
    }

    @Test
    void shouldReturnFalseWhenNoPlayerHas21() {
        Player player = new Player("Alice");

        player.getHand().addCard(
                new BasicCard("Copas", "10")
        );

        BlackjackRule rule = new BlackjackRule();

        Game game = createGame(Arrays.asList(player));

        assertFalse(rule.gameFinished(game));
    }

    @Test
    void shouldReturnPlayerWithHighestValidScore() {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        player1.getHand().addCard(
                new BasicCard("Copas", "18")
        );

        // Como 18 não é um valor válido de carta,
        // usamos 10 + 8.
        player1.getHand().getCards().clear();
        player1.getHand().addCard(
                new BasicCard("Copas", "10")
        );
        player1.getHand().addCard(
                new BasicCard("Ouros", "8")
        );

        player2.getHand().addCard(
                new BasicCard("Paus", "10")
        );
        player2.getHand().addCard(
                new BasicCard("Espadas", "9")
        );

        BlackjackRule rule = new BlackjackRule();

        Game game = createGame(Arrays.asList(player1, player2));

        assertSame(player2, rule.checkWinner(game));
    }

    @Test
    void shouldIgnorePlayersWhoBust() {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        player1.getHand().addCard(
                new BasicCard("Copas", "10")
        );
        player1.getHand().addCard(
                new BasicCard("Ouros", "10")
        );
        player1.getHand().addCard(
                new BasicCard("Paus", "5")
        );

        player2.getHand().addCard(
                new BasicCard("Espadas", "10")
        );
        player2.getHand().addCard(
                new BasicCard("Copas", "9")
        );

        BlackjackRule rule = new BlackjackRule();

        Game game = createGame(Arrays.asList(player1, player2));

        assertSame(player2, rule.checkWinner(game));
    }

    @Test
    void shouldReturnNullWhenAllPlayersBust() {
        Player player = new Player("Alice");

        player.getHand().addCard(
                new BasicCard("Copas", "10")
        );
        player.getHand().addCard(
                new BasicCard("Ouros", "10")
        );
        player.getHand().addCard(
                new BasicCard("Paus", "5")
        );

        BlackjackRule rule = new BlackjackRule();

        Game game = createGame(Arrays.asList(player));

        assertNull(rule.checkWinner(game));
    }

    private Game createGame(List<Player> players) {
        return new TestGame(players);
    }

    private static class TestGame extends Game {

        public TestGame(List<Player> players) {
            super(
                    players,
                    new BlackjackRule(),
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