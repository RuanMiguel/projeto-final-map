package test.framework.cards;

import framework.cards.CardDecorator;
import framework.cards.Card;
import framework.cards.BasicCard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardDecoratorTest {

    @Test
    void shouldReturnWrappedCardType() {
        Card card = new BasicCard("Copas", "A");
        CardDecorator decorator = new CardDecorator(card);

        assertEquals("Copas", decorator.getTipo());
    }

    @Test
    void shouldReturnWrappedCardValue() {
        Card card = new BasicCard("Copas", "A");
        CardDecorator decorator = new CardDecorator(card);

        assertEquals("A", decorator.getValor());
    }
}