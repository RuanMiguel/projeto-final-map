package framework.cards;

public class CardDecorator implements Card {
    protected Card wrappedCard;

    public CardDecorator(Card card) {
        this.wrappedCard = card;
    }

    @Override
    public String getTipo() {
        return wrappedCard.getTipo();
    }

    @Override
    public String getValor() {
        return wrappedCard.getValor();
    }
}