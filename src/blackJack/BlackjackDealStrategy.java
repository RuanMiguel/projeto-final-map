package blackJack;

import framework.cards.Deck;
import framework.player.Player;
import framework.strategy.DealStrategy;
import java.util.List;

/**
 * É uma Concrate Strategy do Padrão Strategy; implementa a estratégia de
 * distribuição de cartas utilizada pelo jogo Blackjack.
 */
public class BlackjackDealStrategy implements DealStrategy {
    /**
     * Distribui duas cartas para cada jogador, alternando a distribuição
     * entre os jogadores.
     *
     * @param deck baralho utilizado para a distribuição
     * @param players jogadores que receberão as cartas
     */
    public void deal(Deck deck, List<Player> players) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < players.size(); j++) {
                Player jogador = players.get(j);
                jogador.getHand().addCard(deck.deal());
            }
        }
    }
}