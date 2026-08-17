package blackJack;

import framework.player.Player;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Jogador 1"));
        players.add(new Player("Dealer"));

        BlackjackRule rule = new BlackjackRule();
        BlackJackDeckFactory deckFactory = new BlackJackDeckFactory();
        BlackjackDealStrategy dealStrategy = new BlackjackDealStrategy();

        BlackjackGame game = new BlackjackGame(players, rule, deckFactory, dealStrategy);

        game.start();
    }
}