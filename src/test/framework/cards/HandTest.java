package test.framework.cards;

import framework.cards.BasicCard;
import framework.cards.Card;
import framework.cards.Hand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void shouldStartWithEmptyHand() {
        Hand hand = new Hand();

        assertTrue(hand.getCards().isEmpty());
    }

    @Test
    void shouldAddCardToHand() {
        Hand hand = new Hand();
        Card card = new BasicCard("Copas", "A");

        hand.addCard(card);

        assertEquals(1, hand.getCards().size());
        assertSame(card, hand.getCards().get(0));
    }

    @Test
    void shouldRemoveCardFromHand() {
        Hand hand = new Hand();
        Card card = new BasicCard("Copas", "A");

        hand.addCard(card);
        hand.removeCard(card);

        assertTrue(hand.getCards().isEmpty());
    }

    @Test
    void shouldContainMultipleCards() {
        Hand hand = new Hand();

        Card card1 = new BasicCard("Copas", "A");
        Card card2 = new BasicCard("Ouros", "K");

        hand.addCard(card1);
        hand.addCard(card2);

        assertEquals(2, hand.getCards().size());
        assertTrue(hand.getCards().contains(card1));
        assertTrue(hand.getCards().contains(card2));
    }
}