package framework.strategy;

import framework.cards.Deck;
import framework.player.Player;
import java.util.List;

/**
 * É a interface Strategy do Padrão Strategy. Define uma
 * estratégia para distribuição de cartas entre os jogadores.
 *
 * Diferentes jogos podem fornecer implementações próprias
 * de acordo com suas regras de distribuição.
 */
public interface DealStrategy {
    /**
     * Distribui cartas do baralho entre os jogadores.
     *
     * @param deck baralho utilizado para a distribuição
     * @param players jogadores que receberão as cartas
     */
    void deal(Deck deck, List<Player> players);
}
