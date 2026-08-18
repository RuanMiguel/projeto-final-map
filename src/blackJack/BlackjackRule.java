package blackJack;

import framework.cards.Card;
import framework.game.Game;
import framework.game.Rule;
import framework.player.Player;

/**
 * Implementa as regras do jogo Blackjack.
 *
 * É responsável por verificar o término da partida,
 * determinar o vencedor e calcular a pontuação dos jogadores.
 */
public class BlackjackRule extends Rule {

    /**
     * Verifica se a partida de Blackjack foi finalizada.
     *
     * A partida é considerada finalizada quando não existem jogadores
     * ou quando algum jogador atinge ou ultrapassa 21 pontos.
     *
     * @param game jogo que será avaliado
     * @return {@code true} se a partida estiver finalizada;
     *         {@code false} caso contrário
     */
    @Override
    public boolean gameFinished(Game game) {
        if (game.getPlayers().isEmpty()) {
            return true;
        }

        for (Player player : game.getPlayers()) {
            if (calculateScore(player) >= 21) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determina o jogador com a maior pontuação sem ultrapassar 21.
     *
     * @param game jogo que será avaliado
     * @return jogador vencedor ou {@code null} caso não exista vencedor
     */
    @Override
    public Player checkWinner(Game game) {
        Player vencedor = null;
        int melhorPontuacao = 0;

        for (Player player : game.getPlayers()) {
            int score = calculateScore(player);
            if (score <= 21 && score > melhorPontuacao) {
                melhorPontuacao = score;
                vencedor = player;
            }
        }
        return vencedor;
    }

    /**
     * Calcula a pontuação de um jogador no Blackjack.
     *
     * As cartas numéricas possuem seu próprio valor, enquanto
     * J, Q, K e 10 valem 10 pontos. O Ás inicialmente vale
     * 11 pontos e pode ser convertido para 1 ponto quando
     * necessário para evitar que a pontuação ultrapasse 21.
     *
     * @param player jogador cuja pontuação será calculada
     * @return pontuação atual do jogador
     */
    public int calculateScore(Player player) {
        int pontuacao = 0;
        int as = 0;

        for (Card card : player.getHand().getCards()) {
            String valor = card.getValor();

            if (valor.equals("A")) {
                as++;
                pontuacao += 11;
            } else if (valor.equals("K") || valor.equals("Q") || valor.equals("J") || valor.equals("10")) {
                pontuacao += 10;
            } else {
                pontuacao += Integer.parseInt(valor);
            }
        }

        // Se a pontuacao for maior que 21, ele muda o valor do às
        while (pontuacao > 21 && as > 0) {
            pontuacao -= 10;
            as--;
        }

        return pontuacao;
    }
}