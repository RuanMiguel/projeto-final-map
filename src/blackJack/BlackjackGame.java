package blackJack;

import framework.factory.DeckFactory;
import framework.game.Game;
import framework.game.Rule;
import framework.player.Player;
import framework.strategy.DealStrategy;

import java.util.List;

public class BlackjackGame extends Game {
    private DeckFactory deckFactory = new BlackJackDeckFactory();
    private DealStrategy dealStrategy = new BlackjackDealStrategy();
    private Rule regra = new Rule();

    public BlackjackGame(List<Player> players, Rule rule, DeckFactory deckFactory, DealStrategy dealStrategy) {
        super(players, rule, deckFactory, dealStrategy);
    }

    protected void createDeck() {
        deck = deckFactory.createDeck();

    }
    protected void shuffle() {
        deck.shuffle();

    }
    protected void dealCards() {
        List<Player> players = List.of();
        dealStrategy.deal(deck, players);
    }
    protected void rounds() {

    }
    protected void finish() {

    }
}