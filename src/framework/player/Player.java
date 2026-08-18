package framework.player;

import framework.cards.Hand;

/**
 * Representa um jogador de uma partida.
 *
 * Mantém o nome do jogador e sua respectiva mão de cartas.
 */
public class Player {
    private String name;
    private Hand hand;

    /**
     * Cria um jogador com o nome informado e uma mão vazia.
     *
     * @param name nome do jogador
     */
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    /**
     * Retorna a mão do jogador.
     *
     * @return mão de cartas do jogador
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Retorna o nome do jogador.
     *
     * @return nome do jogador
     */
    public String getName() {
        return name;
    }
}