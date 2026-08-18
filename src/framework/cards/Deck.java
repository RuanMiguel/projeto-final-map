package framework.cards;

import java.util.Collections;
import java.util.List;

/**
 * Representa um baralho de cartas.
 *
 * Permite embaralhar as cartas, retirar uma carta do baralho
 * e consultar a quantidade de cartas disponíveis.
 */
public class Deck {
    private List<Card> cards;

    /**
     * Cria um baralho com a lista de cartas informada.
     *
     * @param cards lista de cartas que irá compor o baralho
     */
    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    /**
     * Embaralha as cartas do baralho.
     */
    public void shuffle() {
        if (cards != null) {
            Collections.shuffle(cards);
        }
    }

    /**
     * Retira e retorna a primeira carta disponível no baralho.
     *
     * @return carta retirada do baralho ou {@code null} caso
     *         não existam cartas disponíveis
     */
    public Card deal() {
        if (cards == null || cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }

    /**
     * Retorna a quantidade de cartas disponíveis no baralho.
     *
     * @return quantidade de cartas no baralho
     */
    public int size() {
        return cards != null ? cards.size() : 0;
    }
}