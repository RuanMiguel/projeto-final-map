package framework.cards;

/**
 * Implementação básica de uma carta.
 *
 * Armazena o tipo e o valor da carta e fornece acesso
 * a essas informações por meio da interface {@link Card}.
 *
 * É o Concrete Component do padrão Decorator, representado o
 * comportamento original da carta sem o decorator.
 */
public class BasicCard implements Card{
     private final String tipo;
     private final String valor;

    /**
     * Cria uma carta com o tipo e o valor informados.
     *
     * @param tipo tipo ou naipe da carta
     * @param valor valor da carta
     */
     public BasicCard(String tipo, String valor) {
         this.tipo = tipo;
         this.valor = valor;
     }

    /**
     * Retorna o tipo da carta.
     *
     * @return tipo da carta
     */
    @Override
     public String getTipo() {
         return this.tipo;
     }

    /**
     * Retorna o valor da carta.
     *
     * @return valor da carta
     */
     @Override
     public String getValor() {
         return valor;
     }

}
