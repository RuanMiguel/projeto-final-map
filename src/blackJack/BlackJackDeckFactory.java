package blackJack;

import framework.cards.BasicCard;
import framework.cards.Card;
import framework.cards.Deck;
import framework.cards.CardDecorator;
import framework.factory.DeckFactory;
import java.util.ArrayList;
import java.util.List;

public class BlackJackDeckFactory implements DeckFactory {
    public Deck createDeck() {
        List<Card> cards = new ArrayList<>();
        String[] tipos = {"Copas", "Ouros", "Paus", "Espadas"};
        String[] valores = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for (int i = 0; i < tipos.length; i++) {
            for (int j = 0; j < valores.length; j++) {
                BasicCard basicCard = new BasicCard(tipos[i], valores[j]);
                cards.add(new CardDecorator(basicCard));
            }
        }
        return new Deck(cards);
    }
}
