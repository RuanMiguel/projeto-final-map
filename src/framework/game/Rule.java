package framework.game;

import framework.player.Player;

/**
 * Define as regras básicas de uma partida.
 *
 * Pode ser estendida por jogos específicos para implementar
 * as regras de término da partida e determinação do vencedor.
 */
public abstract class Rule {
    /**
     * Verifica se a partida foi finalizada.
     *
     * @param game jogo que será avaliado
     * @return {@code true} se a partida estiver finalizada;
     *         {@code false} caso contrário
     */
    public boolean gameFinished(Game game){
        return true;
    }

    /**
     * Determina o vencedor da partida.
     *
     * @param game jogo que será avaliado
     * @return {@code Player} vencedor da partida;
     *         {@code null} caso não haja vencedor
     */
    public Player checkWinner(Game game){
        return null;
    }
}