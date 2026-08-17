package framework.cards;

import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public void shuffle() {
        if (cards != null) {
            Collections.shuffle(cards);
        }
    }

    public Card deal() {
        if (cards == null || cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }

    public int size() {
        return cards != null ? cards.size() : 0;
    }
}