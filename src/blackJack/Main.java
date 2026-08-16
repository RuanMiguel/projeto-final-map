package blackJack;

import framework.cards.Card;
import framework.cards.Deck;
import framework.player.Player;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // cria jogadores
        List<Player> players = new ArrayList<>();
        players.add(new Player("Jogador 1"));
        players.add(new Player("Dealer"));

        // cria e embaralha o baralho
        BlackJackDeckFactory factory = new BlackJackDeckFactory();
        Deck deck = factory.createDeck();
        System.out.println("Cartas no baralho: " + deck.size());
        deck.shuffle();

        // distribui 2 cartas para cada jogador
        BlackjackDealStrategy dealStrategy = new BlackjackDealStrategy();
        dealStrategy.deal(deck, players);

        // mostra o resultado
        for (Player p : players) {
            System.out.println(p.getName() + ":");
            for (Card c : p.getHand().getCard()) {
                System.out.println("  " + c.getValor() + " de " + c.getNaipe());
            }
        }
        System.out.println("Cartas restantes no baralho: " + deck.size());
    }
}