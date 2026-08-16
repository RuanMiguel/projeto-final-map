package blackJack;

import framework.cards.BasicCard;
import framework.cards.Deck;
import framework.cards.CardDecorator;
import framework.factory.DeckFactory;
import java.util.ArrayList;
import java.util.List;

public class BlackJackDeckFactory implements DeckFactory {
    public Deck createDeck() {
        List<CardDecorator> cards = new ArrayList<>();
        String[] tipos = {"Copas", "Ouros", "Paus", "Espadas"};
        String[] valores = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for (int i = 0; i < tipos.length; i++) {
            for (int j = 0; j < valores.length; j++) {
                cards.add(new BasicCard(tipos, valores));
            }
        }
        return new Deck(cards);
    }
}
