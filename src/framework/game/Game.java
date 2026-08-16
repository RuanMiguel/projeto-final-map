package framework.game;

import framework.cards.Deck;
import framework.factory.DeckFactory;
import framework.player.Player;
import framework.strategy.DealStrategy;

import java.util.List;

public abstract class Game {
    protected Deck deck;
    protected List<Player> players;
    protected Rule rule;
    protected DeckFactory deckFactory;
    protected DealStrategy dealStrategy;

    public Game(List<Player> players, Rule rule, DeckFactory deckFactory, DealStrategy dealStrategy) {
        this.players = players;
        this.rule = rule;
        this.deckFactory = deckFactory;
        this.dealStrategy = dealStrategy;
    }

    public void start() {
        createDeck();
        shuffle();
        dealCards();
        rounds();
        finish();
    }

    protected void createDeck() {
        deck = deckFactory.createDeck();
    }

    protected void shuffle() {
        deck.shuffle();
    }

    protected void dealCards() {
        dealStrategy.deal(deck, players);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Rule getRule() {
        return rule;
    }

    protected abstract void rounds();
    protected abstract void finish();
}