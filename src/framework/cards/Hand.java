package framework.cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<CardDecorator> cardDecorators;

    public Hand() {
        this.cardDecorators = new ArrayList<>();
    }

    public void addCard(CardDecorator cardDecorator) {
        cardDecorators.add(cardDecorator);
    }

    public void removeCard(CardDecorator cardDecorator) {
        cardDecorators.remove(cardDecorator);
    }

    public List<CardDecorator> getCard() {
        return cardDecorators;
    }
}
