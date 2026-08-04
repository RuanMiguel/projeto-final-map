package framework;

public class Cards {
    private final String naipe;
    private final String valor;

    public Cards(String naipe, String valor) {
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
