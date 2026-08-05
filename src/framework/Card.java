package framework;

public class Card {
    private final String naipe;
    private final String valor;

    public Card(String naipe, String valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    public String getNaipe() {
        return naipe;
    }
    public String getValor() {
        return valor;
    }
}
