package test.blackJack;

import blackJack.BlackjackDealStrategy;
import framework.cards.BasicCard;
import framework.cards.Card;
import framework.cards.Deck;
import framework.player.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlackjackDealStrategyTest {

    @Test
    void shouldDealTwoCardsToEachPlayer() {
        List<Card> cards = new ArrayList<>(Arrays.asList(
                new BasicCard("Copas", "A"),
                new BasicCard("Ouros", "2"),
                new BasicCard("Paus", "3"),
                new BasicCard("Espadas", "4")
        ));

        Deck deck = new Deck(cards);

        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        List<Player> players = Arrays.asList(player1, player2);

        BlackjackDealStrategy strategy = new BlackjackDealStrategy();

        strategy.deal(deck, players);

        assertEquals(2, player1.getHand().getCards().size());
        assertEquals(2, player2.getHand().getCards().size());
        assertEquals(0, deck.size());
    }

    @Test
    void shouldDealCardsInRoundOrder() {
        Card first = new BasicCard("Copas", "A");
        Card second = new BasicCard("Ouros", "2");
        Card third = new BasicCard("Paus", "3");
        Card fourth = new BasicCard("Espadas", "4");

        Deck deck = new Deck(new ArrayList<>(
                Arrays.asList(first, second, third, fourth)
        ));

        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        List<Player> players = Arrays.asList(player1, player2);

        BlackjackDealStrategy strategy = new BlackjackDealStrategy();

        strategy.deal(deck, players);

        assertSame(first, player1.getHand().getCards().get(0));
        assertSame(second, player2.getHand().getCards().get(0));
        assertSame(third, player1.getHand().getCards().get(1));
        assertSame(fourth, player2.getHand().getCards().get(1));
    }

    @Test
    void shouldNotDealCardsWhenThereAreNoPlayers() {
        Deck deck = new Deck(new ArrayList<>(
                Arrays.asList(
                        new BasicCard("Copas", "A"),
                        new BasicCard("Ouros", "K")
                )
        ));

        BlackjackDealStrategy strategy = new BlackjackDealStrategy();

        strategy.deal(deck, new ArrayList<>());

        assertEquals(2, deck.size());
    }
}