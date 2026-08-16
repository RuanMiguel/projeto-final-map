package blackJack;

import framework.cards.Deck;
import framework.player.Player;
import framework.strategy.DealStrategy;
import java.util.List;

public class BlackjackDealStrategy implements DealStrategy {
    public void deal(Deck deck, List<Player> players) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < players.size(); j++) {
                Player p = players.get(j);
                p.getHand().addCard(deck.deal());
            }
        }
    }
}