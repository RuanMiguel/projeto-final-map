package framework.game;

import framework.player.Player;

public abstract class Rule {
    public boolean gameFinished(Game game){
        return true;
    }
    public Player checkWinner(Game game){
        return null;
    }
}