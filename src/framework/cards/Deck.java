package framework.cards;

import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> card;

    public Deck(List<Card> cards) {
        this.card = cards;
    }

    public void shuffle() {
        Collections.shuffle(card);
    }

    public Card deal() {
        if (card.isEmpty()) {
            return null;
        }
        return card.removeFirst();
    }

    public int size() {
        return card.size();
    }
}
