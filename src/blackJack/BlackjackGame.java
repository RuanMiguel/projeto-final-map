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

public class BlackjackGame extends Game {

    public BlackjackGame(List<Player> players, Rule rule, DeckFactory deckFactory, DealStrategy dealStrategy) {
        super(players, rule, deckFactory, dealStrategy);
    }

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