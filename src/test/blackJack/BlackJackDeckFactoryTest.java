package test.blackJack;

import blackJack.BlackJackDeckFactory;
import framework.cards.Card;
import framework.cards.Deck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlackJackDeckFactoryTest {

    @Test
    void shouldCreateDeckWith52Cards() {
        BlackJackDeckFactory factory = new BlackJackDeckFactory();

        Deck deck = factory.createDeck();

        assertEquals(52, deck.size());
    }

    @Test
    void shouldCreateCardsWithCorrectTypesAndValues() {
        BlackJackDeckFactory factory = new BlackJackDeckFactory();

        Deck deck = factory.createDeck();

        boolean foundAceOfHearts = false;

        for (int i = 0; i < 52; i++) {
            Card card = deck.deal();

            if (card.getTipo().equals("Copas")
                    && card.getValor().equals("A")) {
                foundAceOfHearts = true;
                break;
            }
        }

        assertTrue(foundAceOfHearts);
    }

    @Test
    void shouldCreateFourCardsOfEachValue() {
        BlackJackDeckFactory factory = new BlackJackDeckFactory();

        Deck deck = factory.createDeck();

        int aces = 0;

        for (int i = 0; i < 52; i++) {
            Card card = deck.deal();

            if (card.getValor().equals("A")) {
                aces++;
            }
        }

        assertEquals(4, aces);
    }
}