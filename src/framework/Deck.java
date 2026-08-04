package framework;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Cards> cards;

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Cards deal() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.removeFirst();
    }

    public int size() {
        return cards.size();
    }
}
