package framework;

import java.util.ArrayList;
import java.util.List;

public class Game {
    protected Deck deck;
    private List<Player> players;
    private Rule rule;

    public void start(){
        deck = new Deck();
        players = new ArrayList<Player>();
    }

    public void round(){
        deck.shuffle();
    }

    public void finish(){
    }
}
