package framework.cards;

import java.util.Collections;
import java.util.List;

public class Deck {
    private List<CardDecorator> cardDecorator;

    public Deck(List<CardDecorator> cardDecorators) {
        this.cardDecorator = cardDecorators;
    }

    public void shuffle() {
        Collections.shuffle(cardDecorator);
    }

    public CardDecorator deal() {
        if (cardDecorator.isEmpty()) {
            return null;
        }
        return cardDecorator.removeFirst();
    }

    public int size() {
        return cardDecorator.size();
    }
}
