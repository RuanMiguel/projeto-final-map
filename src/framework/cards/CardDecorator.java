package framework.cards;

/**
 * Decorador de uma carta.
 *
 * Implementa a interface {@link Card} e encapsula outra carta,
 * delegando a ela as operações de obtenção do tipo e do valor.
 */
public class CardDecorator implements Card {
    protected Card wrappedCard;

    /**
     * Cria um decorador para a carta informada.
     *
     * É o Base Decorator do Padrão Decorator, permitindo que cartas sejam
     * decoradas com funcionalidades adicionais sem alterar a implementação
     * da carta original.
     *
     * @param card carta que será encapsulada
     */
    public CardDecorator(Card card) {
        this.wrappedCard = card;
    }

    /**
     * Retorna o tipo da carta encapsulada.
     *
     * @return tipo da carta
     */
    @Override
    public String getTipo() {
        return wrappedCard.getTipo();
    }

    /**
     * Retorna o valor da carta encapsulada.
     *
     * @return valor da carta
     */
    @Override
    public String getValor() {
        return wrappedCard.getValor();
    }
}