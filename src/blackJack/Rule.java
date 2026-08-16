package blackJack;

import framework.game.Game;
import framework.player.Player;

public interface Rule {
    boolean isGameFinished(Game game);
    Player checkWinner(Game game);
}