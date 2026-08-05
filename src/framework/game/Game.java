package framework.game;

import framework.cards.Deck;
import framework.player.Player;

import java.util.List;

public abstract class Game {
    protected Deck deck;
    private List<Player> players;
    private Rule rule;

    public void start(){
        createDeck();
        shuffle();
        dealCards();
        rounds();
        finish();
    }

    protected abstract void createDeck();
    protected abstract void shuffle();
    protected abstract void dealCards();
    protected abstract void rounds();
    protected abstract void finish();
}
