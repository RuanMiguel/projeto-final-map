package framework.cards;

/**
 * Representa uma carta de um baralho.
 *
 * É a interface Component do padrão Decorator, que define as
 * operações básicas para obter o tipo e o valor de uma carta.
 */
public interface Card {
    /**
     * Retorna o tipo da carta.
     *
     * @return tipo da carta
     */
    String getTipo();

    /**
     * Retorna o valor da carta.
     *
     * @return valor da carta
     */
    String getValor();
}
