package principal;

public class Jogador {
    private Carta[] mao;

    public Jogador(Carta[] mao) {
        this.mao = mao;
    }

    /* MÉTODOS */

    public Carta jogarMaiorCarta() {
        Carta maior = mao[0];

        for (int i=1; i< (mao.length - 1); i++)
            if(mao[i].getValor() > maior.getValor())
                maior = mao[i];

        return maior;
    }

    /*GETTERS E SETTERS*/
    public Carta[] getMao() {
        return mao;
    }

    public void setMao(Carta[] mao) {
        this.mao = mao;
    }
}
