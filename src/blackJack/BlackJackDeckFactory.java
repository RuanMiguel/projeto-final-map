package blackJack;

import framework.cards.BasicCard;
import framework.cards.Card;
import framework.cards.Deck;
import framework.cards.CardDecorator;
import framework.factory.DeckFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * É uma Concrete Factory/Creator do Padrão Factory, responsável pela criação do
 * baralho utilizado no jogo Blackjack.
 */
public class BlackJackDeckFactory implements DeckFactory {
    /**
     * Cria um baralho de 52 cartas, com 4 tipos/naipes (Copas, Ouros, Paus e Espadas) e
     * 13 valores (A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K). Cada carta é criada como
     * um objeto BasicCard e, em seguida, decorada com um CardDecorator antes de ser
     * adicionada ao baralho.
     *
     * @return novo baralho contendo as cartas utilizadas pelo Blackjack
     */
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
