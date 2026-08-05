package framework.strategy;

import framework.cards.Deck;
import framework.player.Player;
import java.util.List;

public interface DealStrategy {
    void deal(Deck deck, List<Player> players);
}
