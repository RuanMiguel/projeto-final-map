package blackJack;

import framework.cards.Card;
import framework.game.Game;
import framework.game.Rule;
import framework.player.Player;

public class BlackjackRule extends Rule {

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