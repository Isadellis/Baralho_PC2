package principal;

public class Carta {
    private int valor;
    private String naipe;

    /*CONSTRUTORES*/
    public Carta() {
        this.valor = 0;
        this.naipe = "";
    }

    public Carta(int valor, String naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    /* MÉTODOS */
    public int compararValor(Carta carta){
        if (this.valor > carta.getValor())
            return 1;
        else if (this.valor == carta.getValor())
            return 0;
        else
            return -1;
    }

    public boolean compararNaipe (Carta carta){
        if ((this.naipe).equals(carta.getNaipe()))
            return true;
        return false;
    }


    /* GETTERS E SETTERS */
    //Getters
    public int getValor() {
        return valor;
    }

    public String getNaipe() {
        return naipe;
    }


    //Setters
    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }
}
