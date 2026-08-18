package blackJack;

import framework.cards.Card;
import framework.cards.CardDecorator;
import framework.factory.DeckFactory;
import framework.game.Game;
import framework.game.Rule;
import framework.player.Player;
import framework.strategy.DealStrategy;

import java.util.List;
import java.util.Scanner;

/**
 * Implementa o fluxo do jogo Blackjack utilizando a infraestrutura fornecida
 * pelo framework.
 *
 * Define o comportamento das rodadas e a finalização da partida de acordo com
 * as regras do Blackjack.
 *
 * É uma Concrete Implementation do Padrão Template Method e o Context do Padrão Strategy.
 */
public class BlackjackGame extends Game {
    /**
     * Cria uma partida de Blackjack.
     *
     * @param players jogadores que participarão da partida
     * @param rule regras utilizadas pelo jogo
     * @param deckFactory fábrica responsável pela criação do baralho
     * @param dealStrategy estratégia utilizada para distribuir as cartas
     */
    public BlackjackGame(List<Player> players, Rule rule, DeckFactory deckFactory, DealStrategy dealStrategy) {
        super(players, rule, deckFactory, dealStrategy);
    }

    /**
     * Executa as rodadas do Blackjack.
     *
     * Controla o comportamento do Dealer e permite que os jogadores
     * decidam se desejam receber novas cartas.
     */
    @Override
    protected void rounds() {
        Scanner scanner = new Scanner(System.in);
        BlackjackRule bjRule = (BlackjackRule) rule;

        for (Player jogador : players) {
            // Lógica do Dealer (Bot)
            if (jogador.getName().equalsIgnoreCase("Dealer")) {
                while (bjRule.calculateScore(jogador) < 17) {
                    Card drawn = deck.deal();
                    if (drawn != null) {
                        jogador.getHand().addCard((CardDecorator) drawn);
                    }
                }
                continue;
            }

            // Lógica do Jogador Humano
            while (bjRule.calculateScore(jogador) < 21) {
                System.out.println("\nSua pontuação atual (" + jogador.getName() + "): " + bjRule.calculateScore(jogador));
                System.out.print("Deseja mais uma carta? (s/n): ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("s")) {
                    Card drawn = deck.deal();
                    if (drawn != null) {
                        jogador.getHand().addCard((CardDecorator) drawn);
                        System.out.println("Você recebeu: " + drawn.getValor() + " de " + drawn.getTipo());
                    }
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Finaliza a partida de Blackjack.
     *
     * Exibe a pontuação dos jogadores e informa o vencedor
     * ou o resultado de empate.
     */
    @Override
    protected void finish() {
        System.out.println("\nPartida encerrada");
        BlackjackRule blackRule = (BlackjackRule) rule;

        for (Player j : players) {
            System.out.println(j.getName() + " - Pontos: " + blackRule.calculateScore(j));
        }

        Player winner = rule.checkWinner(this);
        if (winner != null) {
            System.out.println("\nVencedor: " + winner.getName());
        } else {
            System.out.println("\nEmpate ou todos estouraram!");
        }
    }
}