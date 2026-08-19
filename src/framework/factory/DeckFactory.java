package framework.factory;

import framework.cards.Deck;

/**
 * Define uma fábrica responsável pela criação de baralhos.
 *
 * É o Creator do Padrão Factory Method, permitindo que diferentes jogos forneçam suas
 * próprias implementações para criação do baralho.
 */
public interface DeckFactory {
    /**
     * Cria um novo baralho.
     *
     * @return baralho criado pela fábrica
     */
    public Deck createDeck();
}
