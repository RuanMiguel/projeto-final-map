package test.framework.cards;

import framework.cards.BasicCard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BasicCardTest {

    @Test
    void shouldCreateCardWithTypeAndValue() {
        BasicCard card = new BasicCard("Copas", "A");

        assertEquals("Copas", card.getTipo());
        assertEquals("A", card.getValor());
    }

    @Test
    void shouldCreateCardUsingArrays() {
        String[] tipos = {"Copas", "Ouros"};
        String[] valores = {"A", "K"};

        BasicCard card = new BasicCard(tipos, valores);

        assertEquals("Copas", card.getTipo());
        assertEquals("A", card.getValor());
    }
}