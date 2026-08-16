package framework.cards;

public class Card {
    private final String tipo;
    private final String valor;

    public Card(String naipe, String valor) {
        this.tipo = naipe;
        this.valor = valor;
    }

    public String getNaipe() {
        return tipo;
    }
    public String getValor() {
        return valor;
    }
}
