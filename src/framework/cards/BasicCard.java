package framework.cards;

public class BasicCard implements Card{
     private final String tipo;
     private final String valor;

     public BasicCard(String tipo, String valor) {
         this.tipo = tipo;
         this.valor = valor;
     }

    public BasicCard(String[] tipos, String[] valores) {
         this.tipo = tipos[0];
         this.valor = valores[0];
    }

    @Override
     public String getTipo() {
         return this.tipo;
     }

     @Override
     public String getValor() {
         return valor;
     }

}
