package test.framework.cards;

import framework.cards.BasicCard;
import framework.cards.Card;
import framework.cards.Deck;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void shouldReturnCorrectDeckSize() {
        List<Card> cards = new ArrayList<>(Arrays.asList(
                new BasicCard("Copas", "A"),
                new BasicCard("Ouros", "K")
        ));

        Deck deck = new Deck(cards);

        assertEquals(2, deck.size());
    }

    @Test
    void shouldDealFirstCard() {
        Card firstCard = new BasicCard("Copas", "A");
        Card secondCard = new BasicCard("Ouros", "K");

        Deck deck = new Deck(new ArrayList<>(Arrays.asList(
                firstCard,
                secondCard
        )));

        Card dealtCard = deck.deal();

        assertSame(firstCard, dealtCard);
        assertEquals(1, deck.size());
    }

    @Test
    void shouldReturnNullWhenDeckIsEmpty() {
        Deck deck = new Deck(new ArrayList<>());

        assertNull(deck.deal());
    }

    @Test
    void shouldReturnZeroSizeWhenDeckIsEmpty() {
        Deck deck = new Deck(new ArrayList<>());

        assertEquals(0, deck.size());
    }

    @Test
    void shouldShuffleDeckWithoutChangingItsSize() {
        List<Card> cards = new ArrayList<>(Arrays.asList(
                new BasicCard("Copas", "A"),
                new BasicCard("Ouros", "K"),
                new BasicCard("Espadas", "Q"),
                new BasicCard("Paus", "J")
        ));

        Deck deck = new Deck(cards);

        int sizeBefore = deck.size();

        deck.shuffle();

        assertEquals(sizeBefore, deck.size());
    }

    @Test
    void shouldHandleNullCardList() {
        Deck deck = new Deck(null);

        assertEquals(0, deck.size());
        assertNull(deck.deal());

        assertDoesNotThrow(deck::shuffle);
    }
}