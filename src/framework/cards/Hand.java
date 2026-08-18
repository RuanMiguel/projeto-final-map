package framework.cards;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a mão de um jogador.
 *
 * Mantém as cartas que pertencem ao jogador e permite
 * adicionar, remover e consultar cartas.
 */
public class Hand {
    private List<Card> cards;

    /**
     * Cria uma mão vazia.
     */
    public Hand() {
        this.cards = new ArrayList<>();
    }

    /**
     * Adiciona uma carta à mão.
     *
     * @param card carta que será adicionada
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Remove uma carta da mão.
     *
     * @param card carta que será removida
     */
    public void removeCard(Card card) {
        cards.remove(card);
    }

    /**
     * Retorna as cartas que estão na mão.
     *
     * @return lista de cartas da mão
     */
    public List<Card> getCards() {
        return cards;
    }
}